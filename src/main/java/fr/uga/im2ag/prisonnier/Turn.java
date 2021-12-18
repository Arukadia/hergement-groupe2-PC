package fr.uga.im2ag.prisonnier;

public class Turn {

	private Actions actionP1;
	private Actions actionP2;
	private int scoreP1;
	private int scoreP2;
	
	public Turn() {
		this.actionP1=Actions.NULL;
		this.actionP2=Actions.NULL;
		this.scoreP1=0;
		this.scoreP2=0;
	}

	public Actions getActionP1() {
		return actionP1;
	}

	public void setActionP1(Actions actionP1) {
		this.actionP1 = actionP1;
	}

	public Actions getActionP2() {
		return actionP2;
	}

	public void setActionP2(Actions actionP2) {
		this.actionP2 = actionP2;
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
		if (actionP1==Actions.C) {
			if (actionP2==Actions.C) {
				setScoreP1(3);
				setScoreP2(3);
			} else {
				setScoreP1(0);
				setScoreP2(5);
			}
		} else {
			if (actionP2==Actions.C) {
				setScoreP1(5);
				setScoreP2(0);
			} else {
				setScoreP1(1);
				setScoreP2(1);
			} 
		}
	}
}
