package fr.uga.im2ag.prisonnier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestGame {

	@Test
	void Test_Getters() {
		Player p0 = new Player("Guillaume");
		Game g0 = new Game(5,p0);
		Game g1 = new Game();
		
		Assertions.assertEquals(null, g1.getState());
		Assertions.assertEquals(0, g1.getNbTurn());
		Assertions.assertEquals(null, g1.getPlayerOne());
		Turn A = new Turn();
		Turn[] T = {A};
		g1.setTurns(T);
		Assertions.assertEquals(T, g1.getTurns());
		
		Assertions.assertEquals(State.PENDING, g0.getState());
		Assertions.assertEquals(5, g0.getNbTurn());
		Assertions.assertEquals(g0.getPlayerOne(), p0);
	}
	
	@Test
	void Test_Setters() {
		Player p0 = new Player("Guillaume");
		Player p1 = new Player("Julien");
		Game g0 = new Game(5,p0);
		g0.setState(State.INPROGRESS);
		Assertions.assertEquals(State.INPROGRESS, g0.getState());
		g0.setNbTurn(10);
		Assertions.assertEquals(10, g0.getNbTurn());
		g0.setPlayerOne(p1);
		Assertions.assertEquals(g0.getPlayerOne(), p1);
	}
	
	@Test
	void Test_SetScore() {
		Player p0 = new Player("Guillaume");
		Game g0 = new Game(5,p0);
		Turn t0 = new Turn();
		t0.setScoreP1(5);
		t0.setScoreP2(0);
		Turn t1 = new Turn();
		t1.setScoreP1(1);
		t1.setScoreP2(1);
		g0.getTurns()[0]=t0;
		g0.getTurns()[1]=t1;
		g0.setScore();
		Assertions.assertEquals(6, g0.getScoreP1());
		Assertions.assertEquals(1, g0.getScoreP2());
	}
	
	@Test
	void Test_SetStrategy() {
		Player p0 = new Player("Guillaume");
		Game g0 = new Game(5,p0);
		Strategy s1 = new GiveAndTake();
		Strategy s2 = new AlwaysBetray();
		
		g0.setStratP1(s1);
		g0.setStratP2(s2);
		
		Assertions.assertEquals(s1, g0.getStratP1());
		Assertions.assertEquals(s2, g0.getStratP2());
		
		
	}
}
