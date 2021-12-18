package fr.uga.im2ag.prisonnier;

public class GameStrat {

	int id;
    String pseudo;
    String name;

    public GameStrat(int id, String pseudo, String name) {
		this.id = id;
		this.pseudo = pseudo;
		this.name = name;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
