package fr.uga.im2ag.prisonnier;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import java.util.Set;

import org.reflections.Reflections;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.classes.Alternant;

@RestController
@CrossOrigin
@RequestMapping("/") 
public class Connection {

		
	ArrayList<Game> games = new ArrayList<>();
	ArrayList<Player> players = new ArrayList<>();
	ArrayList<Strategy> strategies = new ArrayList<>();
	
	@GetMapping("/")
    public String index() {
	    return "index";
	 }
	
	@PostMapping("/createplayer")
    public Player createPlayer(@RequestBody String s) {
	    Player p = new Player(s);
	    players.add(p);
	    return p;
	 }
	
	@PostMapping("/creategame")
	public Game createGame(@RequestBody Game g) {
		Game game = new Game(g.getNbTurn(),g.getPlayerOne());
		if (games.isEmpty()) game.setId(0);
		else game.setId(games.get(games.size()-1).getId()+1);
		games.add(game);
		return game;
	}
	
	@GetMapping("/getallgamespending")
	public List<Game> getGames() {
		ArrayList<Game> g = new ArrayList<Game>();
		for (Game game: games) {
			if (game.getState()==State.PENDING) {
				g.add(game);
			}
		}
		return g;
	}
	
	@GetMapping("/getgameid/{id}")
	public Game getGame(@PathVariable(value="id") int id) {
		Game game=null;
	    for (Game g : games) {
	    	if (g.getId()==id) game=g;
	    }
	    return game;
	 }
	
	@PostMapping("/modifygame")
	public Game modifyGame(@RequestBody Game g) {
		for (Game game: games) {
			if (game.getId()==g.getId()) {
				games.set(games.indexOf(game), g);
			}
		}
		return g;
	}
	
	@DeleteMapping("/deletegame")
	public boolean deleteGame(@RequestBody int id) {
		for (Game game: games) {
			if (game.getId()==id) {
				games.remove(game);
				return true;
			}
		}
		return false;
	}
	
	@PostMapping("/putgameplay")
	public Game putGamePlay(@RequestBody GamePlay gameplay) {
		Game game=null;
		int id = gameplay.getId();
	    String pseudo = gameplay.getPseudo();
	    Actions action = gameplay.getAction();
		for (Game g: games) {
			if (g.getId()==id) {
				int i =0;				
				if (g.getPlayerOne().getPseudo().equals(pseudo)) {
					while (g.getNbTurn()>i && g.getTurns()[i].getActionP1()!=Actions.NULL) {
							i++;
					}
					g.getTurns()[i].setActionP1(action);
					if(g.getStratP2()!=null) {
						g.getTurns()[i].setActionP2(g.getStratP2().getAction(g.getTurns(), 1));
					}
//					if (i==0 || g.getTurns()[i-1].getActionP2()!=Actions.NULL) {
//						if (g.getStratP1()!=null) {
//							g.getTurns()[i].setActionP1(g.getStratP1().getAction(g.getTurns(), 0));
//						} else {
//							g.getTurns()[i].setActionP1(action);
//						}
//						if (g.getTurns()[i].getActionP2()!=Actions.NULL) {
//							g.getTurns()[i].setScore();
//							g.setScore();
//						}
//						game = g;
//					}
				} else {
					while (g.getNbTurn()>i && g.getTurns()[i].getActionP2()!=Actions.NULL) {
						i++;
					}
					g.getTurns()[i].setActionP2(action);
					if(g.getStratP1()!=null) {
						g.getTurns()[i].setActionP1(g.getStratP1().getAction(g.getTurns(), 0));
					}
//					if (i==0 || g.getTurns()[i-1].getActionP2()!=Actions.NULL) {
//						if (g.getStratP2()!=null) {
//							g.getTurns()[i].setActionP2(g.getStratP2().getAction(g.getTurns(), 1));
//						} else {
//							g.getTurns()[i].setActionP2(action);
//						}
//						if (g.getTurns()[i].getActionP1()!=Actions.NULL) {
//							g.getTurns()[i].setScore();
//							g.setScore();
//						}
//						game = g;
//					}
				}
				game = g;
			}
		}
		return game;
	}
	
	@PostMapping("/putstrategy")
	public Game putStrategy(@RequestBody GameStrat gamestrat) {
		Game game=null;
		int id = gamestrat.getId();
	    String pseudo = gamestrat.getPseudo();
	    String name = gamestrat.getName();
	    Strategy strat=null;
		for (Game g: games) {
			if (g.getId()==id) {
				switch(name) {
				case "AlwaysBetray":
					strat = new AlwaysBetray();
					break;
				case "AlwaysCoop":
					strat = new AlwaysCoop();
					break;
				case "GiveAndTake":
					strat = new GiveAndTake();
					break;
				case "Alternant":
					//cas Jar alternant : dispo dans les import
					break;
				default:
					strat = null;
				}
				if (g.getPlayerOne()!= null && g.getPlayerOne().getPseudo().equals(pseudo)) {
					g.setStratP1(strat);
					g.setPlayerOne(null);
				} else {
					g.setStratP2(strat);
					g.setPlayerTwo(null);
				}
				game = g;
			}
		}
		return game;
	}
	
	@GetMapping("/getstrategy")
	public List<Strategy> getAllStrategy() {
		ArrayList<Strategy> strats = new ArrayList<Strategy>();
		Reflections reflections = new Reflections("fr.uga.im2ag.prisonnier");
		Set<Class<? extends Strategy>> subTypes = 
		reflections.getSubTypesOf(Strategy.class);
		for (Class<? extends Strategy> strat : subTypes) {
			Class<?> strategy;
			try {
				strategy = Class.forName(strat.getName());
				Strategy s = (Strategy) strategy.getDeclaredConstructor().newInstance();
				strats.add(s);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return strats;
	}
	
	@PostMapping("/getlastturn")
	public Actions getLastTurn(@RequestBody GamePlay gameplay) {
		int id = gameplay.getId();
	    String pseudo = gameplay.getPseudo();
	    Actions a =null;
		for (Game g: games) {
			if (g.getId()==id) {
				int i =0;
				if (g.getPlayerOne().getPseudo().equals(pseudo)) {
					while (g.getTurns()[i].getActionP1()!=Actions.NULL) {
							i++;
					}
					if (i==0) {
						a = g.getTurns()[i].getActionP1();
					} else {
						a = g.getTurns()[i-1].getActionP1();
					}
				} else {
					while (g.getTurns()[i].getActionP2()!=Actions.NULL) {
						i++;
					}
					if (i==0) {
						a = g.getTurns()[i].getActionP2();
					} else {
						a = g.getTurns()[i-1].getActionP2();
					}
				}
			}
		}
		return a;
	}
	
}
