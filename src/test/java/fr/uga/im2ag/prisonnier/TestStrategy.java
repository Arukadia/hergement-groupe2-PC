package fr.uga.im2ag.prisonnier;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

class TestStrategy {

	@Test
	void Test_Getters() {
		AlwaysCoop s0 = new AlwaysCoop();
		AlwaysBetray s1 = new AlwaysBetray();
		GiveAndTake s2 = new GiveAndTake();
		Player p= new Player("Guillaume");
		Game g0 = new Game(5,p);
		Assertions.assertEquals(Actions.C, s0.getAction(g0.getTurns(),0));
		Assertions.assertEquals(Actions.T, s1.getAction(g0.getTurns(),0));
		
		Assertions.assertEquals(Actions.C, s2.getAction(g0.getTurns(),0));
		Assertions.assertEquals(Actions.C, s2.getAction(g0.getTurns(),1));
		g0.getTurns()[0].setActionP2(Actions.C);		
		Assertions.assertEquals(Actions.C, s2.getAction(g0.getTurns(),0));
		g0.getTurns()[0].setActionP1(Actions.T);
		Assertions.assertEquals(Actions.T, s2.getAction(g0.getTurns(),1));
		g0.getTurns()[1].setActionP2(Actions.C);
		g0.getTurns()[1].setActionP1(Actions.T);
		Assertions.assertEquals(Actions.C, s2.getAction(g0.getTurns(),0));
		Assertions.assertEquals(Actions.T, s2.getAction(g0.getTurns(),1));
		g0.getTurns()[2].setActionP2(Actions.C);		
		Assertions.assertEquals(Actions.C, s2.getAction(g0.getTurns(),0));
		g0.getTurns()[2].setActionP1(Actions.T);
		Assertions.assertEquals(Actions.T, s2.getAction(g0.getTurns(),1));
		
		
		Game g1 = new Game(1,p);
		g1.getTurns()[0].setActionP1(Actions.C);
		Assertions.assertEquals(Actions.NULL, s2.getAction(g1.getTurns(),1));
		
		
		
		Assertions.assertEquals("GiveAndTake", s2.getName());
		Assertions.assertEquals("Play like your opponent", s2.getDesc());
		Assertions.assertEquals("AlwaysCoop", s0.getName());
		Assertions.assertEquals("Always be nice", s0.getDesc());
		Assertions.assertEquals("AlwaysBetray", s1.getName());
		Assertions.assertEquals("Always be mean", s1.getDesc());
	}
}
