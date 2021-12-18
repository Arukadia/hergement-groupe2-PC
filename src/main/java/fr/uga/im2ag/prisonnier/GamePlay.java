package fr.uga.im2ag.prisonnier;


public class GamePlay {
	
    int id;
    String pseudo;
    Actions action;

	public GamePlay() {}
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
	}

}
