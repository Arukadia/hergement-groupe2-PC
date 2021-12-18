package fr.uga.im2ag.prisonnier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestGamePlay {

	@Test
	void Test_Getters() {
		GamePlay g0= new GamePlay();
		g0.setId(0);
		g0.setPseudo("Guillaume");
		g0.setAction(Actions.T);
		Assertions.assertEquals(0, g0.getId());
		Assertions.assertEquals("Guillaume", g0.getPseudo());
		Assertions.assertEquals(Actions.T, g0.getAction());
	}
	
	@Test
	void Test_Setters() {
		GamePlay g0= new GamePlay();
		g0.setId(1);
		Assertions.assertEquals(1, g0.getId());
		g0.setPseudo("Julien");
		Assertions.assertEquals("Julien", g0.getPseudo());
		g0.setAction(Actions.C);
		Assertions.assertEquals(Actions.C, g0.getAction());
	}

}
