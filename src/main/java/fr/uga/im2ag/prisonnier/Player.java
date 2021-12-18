package fr.uga.im2ag.prisonnier;

public class Player {
	private String pseudo;

	public Player() {}
	public Player(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public Game createGame(int nbLap) {
		Game g = new Game(nbLap,this);		
		return g;
	}
	
	public void leaveGame(Game game) {
		if (game.getPlayerOne()==this) game.setPlayerOne(null);
		else game.setPlayerTwo(null);
	}
	
	public void joinGame(Game game) {
		game.setPlayerTwo(this);
	}
}
