package fr.uga.im2ag.prisonnier;

import java.util.Arrays;

public class Game {

	private int id;
	private int nbTurn;
	private Player playerOne;
	private Player playerTwo;
	private Turn[] turns;
	private State state;
	private Strategy stratP1;
	private Strategy stratP2;
	private int scoreP1 = 0;
	private int scoreP2 = 0;
	
	public Game() {} 

	public Game(int nbTurn, Player p) {
		this.nbTurn= nbTurn;
		this.playerOne = p;
		this.turns = new Turn[nbTurn];
		for (int i=0;i<nbTurn;i++) {
			turns[i]= new Turn();
		}
		this.state=State.PENDING;
	}
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", nbTurn=" + nbTurn + ", playerOne=" + playerOne + ", playerTwo=" + playerTwo
				+ ", turns=" + Arrays.toString(turns) + ", state=" + state + ", stratP1=" + stratP1 + ", stratP2="
				+ stratP2 + ", scoreP1=" + scoreP1 + ", scoreP2=" + scoreP2 + "]";
	}

	public int getId() {
		return id;
	}

	public Turn[] getTurns() {
		return turns;
	}

	public void setTurns(Turn[] turns) {
		this.turns = turns;
	}
	

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNbTurn() {
		return nbTurn;
	}

	public void setNbTurn(int nbTurn) {
		this.nbTurn = nbTurn;
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

	public Strategy getStratP1() {
		return stratP1;
	}

	public void setStratP1(Strategy stratP1) {
		this.stratP1 = stratP1;
	}

	public Strategy getStratP2() {
		return stratP2;
	}

	public void setStratP2(Strategy stratP2) {
		this.stratP2 = stratP2;
	}

	public int getScoreP1() {
		return scoreP1;
	}

	public void setScoreP1(int scoreP1) {
		this.scoreP1 = scoreP1;
	}

	public int getScoreP2() {
		return scoreP2;
	}

	public void setScoreP2(int scoreP2) {
		this.scoreP2 = scoreP2;
	}
	
	public void setScore() {
		setScoreP1(0);
		setScoreP2(0);
		for (Turn t: turns) {
			setScoreP1(getScoreP1()+t.getScoreP1());
			setScoreP2(getScoreP2()+t.getScoreP2());
		}
	}


}
