package fr.uga.im2ag.prisonnier;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestConnection {
	
	@Test
	void Test_PutStrategyAB() {
		Connection C = new Connection();
		Player p1 = new Player("Guillaume");
		Player p2 = new Player("Julien");
		Game g1 = new Game(4, p1);
		C.createGame(g1);
		g1.setId(0);
		g1.setPlayerTwo(p2);
		C.modifyGame(g1);
		GameStrat gs1 = new GameStrat(0, "Guillaume", "AlwaysBetray");
		GameStrat gs2 = new GameStrat(0, "Julien", "AlwaysBetray");
		Game g2 = C.putStrategy(gs1);
		Strategy s1 = new AlwaysBetray();
		Assertions.assertEquals(s1.getClass(),g2.getStratP1().getClass());
		g2 = C.putStrategy(gs2);
		Assertions.assertEquals(s1.getClass(),g2.getStratP2().getClass());		
	}
	
	@Test
	void Test_PutStrategyAC() {
		Connection C = new Connection();
		Player p1 = new Player("Guillaume");
		Player p2 = new Player("Julien");
		Game g1 = new Game(4, p1);
		C.createGame(g1);
		g1.setId(0);
		g1.setPlayerTwo(p2);
		C.modifyGame(g1);
		GameStrat gs1 = new GameStrat(0, "Guillaume", "AlwaysCoop");
		GameStrat gs2 = new GameStrat(0, "Julien", "AlwaysCoop");
		Game g2 = C.putStrategy(gs1);
		Strategy s1 = new AlwaysCoop();
		Assertions.assertEquals(s1.getClass(),g2.getStratP1().getClass());
		g2 = C.putStrategy(gs2);
		Assertions.assertEquals(s1.getClass(),g2.getStratP2().getClass());		
	}
	
	@Test
	void Test_PutStrategyGAT() {
		Connection C = new Connection();
		Player p1 = new Player("Guillaume");
		Player p2 = new Player("Julien");
		Game g1 = new Game(4, p1);
		C.createGame(g1);
		g1.setId(0);
		g1.setPlayerTwo(p2);
		C.modifyGame(g1);
		GameStrat gs1 = new GameStrat(0, "Guillaume", "GiveAndTake");
		GameStrat gs2 = new GameStrat(0, "Julien", "GiveAndTake");
		Game g2 = C.putStrategy(gs1);
		Strategy s1 = new GiveAndTake();
		Assertions.assertEquals(s1.getClass(),g2.getStratP1().getClass());
		g2 = C.putStrategy(gs2);
		Assertions.assertEquals(s1.getClass(),g2.getStratP2().getClass());		
	}
	
	@Test
	void Test_PutStrategyBUG() {
		Connection C = new Connection();
		Player p1 = new Player("Guillaume");
		Player p2 = new Player("Julien");
		Game g1 = new Game(4, p1);
		C.createGame(g1);
		g1.setId(0);
		g1.setPlayerTwo(p2);
		C.modifyGame(g1);
		GameStrat gs1 = new GameStrat(0, "Guillaume", "bug");
		GameStrat gs2 = new GameStrat(0, "Julien", "bug");
		Game g2 = C.putStrategy(gs1);
		Assertions.assertEquals(null,g2.getStratP1());
		g2 = C.putStrategy(gs2);
		Assertions.assertEquals(null,g2.getStratP2());
		gs2.setId(5);
		g2 = C.putStrategy(gs2);
		
		Assertions.assertEquals(null, g2);
	}

	@Test
	void Test_CreatePlayerAndGame() {
		Player p = new Player("Guillaume");
		Connection C = new Connection();
		Player p0 = C.createPlayer("Guillaume");
		Assertions.assertEquals(p.getPseudo(), p0.getPseudo());
		Assertions.assertEquals("index", C.index());

		Game g = new Game(4, p);
		g.setId(0);
		
		Game g0 = C.createGame(g);
		Assertions.assertEquals(g.getId(), g0.getId());
		Assertions.assertEquals(g.getNbTurn(), g0.getNbTurn());
		Assertions.assertEquals(g.getScoreP1(), g0.getScoreP1());
		Assertions.assertEquals(g.getScoreP2(), g0.getScoreP2());
		Assertions.assertEquals(g.getPlayerOne(), g0.getPlayerOne());
		Assertions.assertEquals(g.getPlayerTwo(), g0.getPlayerTwo());
		Assertions.assertEquals(g.getState(), g0.getState());
		Assertions.assertEquals(g.getStratP1(), g0.getStratP1());
		Assertions.assertEquals(g.getStratP2(), g0.getStratP2());
		
		Game g2 = new Game(4, p);
		g2.setId(1);
		Game g1 = C.createGame(g);
		Assertions.assertEquals(g2.getId(), g1.getId());
		Assertions.assertEquals(g2.getNbTurn(), g1.getNbTurn());
		Assertions.assertEquals(g2.getScoreP1(), g1.getScoreP1());
		Assertions.assertEquals(g2.getScoreP2(), g1.getScoreP2());
		Assertions.assertEquals(g2.getPlayerOne(), g1.getPlayerOne());
		Assertions.assertEquals(g2.getPlayerTwo(), g1.getPlayerTwo());
		Assertions.assertEquals(g2.getState(), g1.getState());
		Assertions.assertEquals(g2.getStratP1(), g1.getStratP1());
		Assertions.assertEquals(g2.getStratP2(), g1.getStratP2());
		
		Game g3 = C.getGame(0);		
		Assertions.assertEquals(g0, g3);
		Game g4 = C.getGame(4);		
		Assertions.assertEquals(null, g4);
		g.setScoreP1(5);
		Game g5 = C.modifyGame(g);
		Assertions.assertEquals(g, g5);
		boolean b = C.deleteGame(0);
		boolean b1 = C.deleteGame(4);
		Assertions.assertEquals(true, b);
		Assertions.assertEquals(false, b1);		
		
	}
	
	@Test
	void Test_putGamePlay() {
		Connection C = new Connection();
		GamePlay gp = new GamePlay();
		gp.setId(0);
		gp.setAction(Actions.C);
		gp.pseudo="Guillaume";
		Player p = new Player("Guillaume");
		Player p1 = new Player("Julien");
		GamePlay gp1 = new GamePlay();
		gp1.setId(0);
		gp1.setAction(Actions.C);
		gp1.pseudo="Julien";
		Game g = new Game(4, p);
		C.createGame(g);
		g.getTurns()[0].setActionP1(Actions.C);
		g.getTurns()[0].setActionP2(Actions.C);
		Game g0 = C.putGamePlay(gp);
		Game g1 = C.putGamePlay(gp1);
		Assertions.assertEquals(g.getTurns()[0].getActionP2(), g1.getTurns()[0].getActionP2());
		Assertions.assertEquals(g.getTurns()[0].getActionP1(), g0.getTurns()[0].getActionP1());
		
		GamePlay gp2 = new GamePlay();
		gp2.setId(99);
		gp2.setAction(Actions.T);
		gp2.setPseudo("Guillaume");
		Game g2 = C.putGamePlay(gp2);
		Assertions.assertEquals(null, g2);
		
		
//		Player p3 = new Player("Guillaume");
//		Game g03 = new Game(1, p3);
//		Strategy s1 = new AlwaysCoop();
//		g03.setStratP1(s1);
//		g03.setId(1);
//		C.createGame(g03);
//		
//		GamePlay gp3 = new GamePlay();
//		gp3.setId(1);
//		gp3.setAction(Actions.T);
//		gp3.setPseudo("Guillaume");
//		g03.getTurns()[0].setActionP1(Actions.T);
//		g03.getTurns()[0].setActionP2(Actions.C);
//		Game g3 = C.putGamePlay(gp3);
//		Assertions.assertEquals(g03, g3);
	}
	
	@Test
	void Test_getGames() {
		Player p = new Player("Guillaume");
		Connection C = new Connection();
		Player p0 = C.createPlayer("Guillaume");
		Assertions.assertEquals(p.getPseudo(), p0.getPseudo());
		Assertions.assertEquals("index", C.index());

		Game g = new Game(4, p);
		g.setId(0);
		
		Game g0 = C.createGame(g);
		Assertions.assertEquals(g.getId(), g0.getId());
		Assertions.assertEquals(g.getNbTurn(), g0.getNbTurn());
		Assertions.assertEquals(g.getScoreP1(), g0.getScoreP1());
		Assertions.assertEquals(g.getScoreP2(), g0.getScoreP2());
		Assertions.assertEquals(g.getPlayerOne(), g0.getPlayerOne());
		Assertions.assertEquals(g.getPlayerTwo(), g0.getPlayerTwo());
		Assertions.assertEquals(g.getState(), g0.getState());
		Assertions.assertEquals(g.getStratP1(), g0.getStratP1());
		Assertions.assertEquals(g.getStratP2(), g0.getStratP2());
		
		Game g2 = new Game(4, p);
		g2.setId(1);
		Game g1 = C.createGame(g);
		Assertions.assertEquals(g2.getId(), g1.getId());
		Assertions.assertEquals(g2.getNbTurn(), g1.getNbTurn());
		Assertions.assertEquals(g2.getScoreP1(), g1.getScoreP1());
		Assertions.assertEquals(g2.getScoreP2(), g1.getScoreP2());
		Assertions.assertEquals(g2.getPlayerOne(), g1.getPlayerOne());
		Assertions.assertEquals(g2.getPlayerTwo(), g1.getPlayerTwo());
		Assertions.assertEquals(g2.getState(), g1.getState());
		Assertions.assertEquals(g2.getStratP1(), g1.getStratP1());
		Assertions.assertEquals(g2.getStratP2(), g1.getStratP2());
		g1.setState(State.DONE);
		C.modifyGame(g1);
		List<Game> a = C.getGames();
		Game t1 = a.get(0);
		Assertions.assertEquals(g.getId(), t1.getId());
		Assertions.assertEquals(g.getNbTurn(), t1.getNbTurn());
		Assertions.assertEquals(g.getScoreP1(), t1.getScoreP1());
		Assertions.assertEquals(g.getScoreP2(), t1.getScoreP2());
		Assertions.assertEquals(g.getPlayerOne(), t1.getPlayerOne());
		Assertions.assertEquals(g.getPlayerTwo(), t1.getPlayerTwo());
		Assertions.assertEquals(g.getState(), t1.getState());
		Assertions.assertEquals(g.getStratP1(), t1.getStratP1());
		Assertions.assertEquals(g.getStratP2(), t1.getStratP2());
		
	}
	
	@Test
	void Test_getLastTurn() {
		Player p = new Player("Guillaume");
		Connection C = new Connection();
		Game g = new Game(4, p);
		g.setId(0);		
		Game g0 = C.createGame(g);
		GamePlay gp = new GamePlay();
		gp.id=0;
		gp.pseudo="Guillaume";
		Actions a = C.getLastTurn(gp);
		Assertions.assertEquals(Actions.NULL, a);
		g.getTurns()[0].setActionP1(Actions.C);
		C.modifyGame(g);
		a = C.getLastTurn(gp);
		Assertions.assertEquals(Actions.C, a);
		
		GamePlay gp1 = new GamePlay();
		gp.id=0;
		gp.pseudo="Julien";
		Player p1 = new Player("Julien");
		g.setPlayerTwo(p1);
		C.modifyGame(g);		
		a = C.getLastTurn(gp1);
		Assertions.assertEquals(Actions.NULL, a);
		g.getTurns()[0].setActionP2(Actions.T);		
		C.modifyGame(g);
		a = C.getLastTurn(gp1);
		Assertions.assertEquals(Actions.T, a);
	}
}
