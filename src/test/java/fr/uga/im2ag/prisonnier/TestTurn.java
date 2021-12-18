package fr.uga.im2ag.prisonnier;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestTurn {

	@Test
	void Test_Getters() {
		Turn t0 = new Turn();
		Assertions.assertEquals(Actions.NULL,t0.getActionP1());
		Assertions.assertEquals(Actions.NULL,t0.getActionP2());
		Assertions.assertEquals(0 ,t0.getScoreP2());
		Assertions.assertEquals(0 ,t0.getScoreP1());
		t0.setActionP1(Actions.C);
		t0.setActionP2(Actions.T);
		Assertions.assertEquals(Actions.C, t0.getActionP1());
		Assertions.assertEquals(Actions.T, t0.getActionP2());
	}
	
	@Test
	void Test_Setters() {
		Turn t0 = new Turn();
		t0.setActionP1(Actions.T);
		Assertions.assertEquals(Actions.T, t0.getActionP1());
		t0.setActionP2(Actions.C);
		Assertions.assertEquals(Actions.C, t0.getActionP2());
		t0.setScoreP1(5);
		t0.setScoreP2(3);
		Assertions.assertEquals(3 ,t0.getScoreP2());
		Assertions.assertEquals(5 ,t0.getScoreP1());
	}
	
	@Test
	void Test_SetScore() {
		Turn t0 = new Turn();
		t0.setActionP1(Actions.C);
		t0.setActionP2(Actions.C);
		t0.setScore();
		Assertions.assertEquals(3 ,t0.getScoreP2());
		Assertions.assertEquals(3 ,t0.getScoreP1());
		
		t0.setActionP1(Actions.C);
		t0.setActionP2(Actions.T);
		t0.setScore();
		Assertions.assertEquals(5 ,t0.getScoreP2());
		Assertions.assertEquals(0 ,t0.getScoreP1());
		
		t0.setActionP1(Actions.T);
		t0.setActionP2(Actions.T);
		t0.setScore();
		Assertions.assertEquals(1 ,t0.getScoreP2());
		Assertions.assertEquals(1 ,t0.getScoreP1());
	}

}
