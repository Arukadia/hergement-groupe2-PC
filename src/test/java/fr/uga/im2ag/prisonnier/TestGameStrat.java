package fr.uga.im2ag.prisonnier;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestGameStrat {

	@Test
	void Test_Getters() {
		GameStrat g0= new GameStrat(0,"Guillaume","Hello");
		Assertions.assertEquals(0, g0.getId());
		Assertions.assertEquals("Guillaume", g0.getPseudo());
		Assertions.assertEquals("Hello", g0.getName());
	}
	
	@Test
	void Test_Setters() {
		GameStrat g0= new GameStrat(0,"Guillaume","test");
		g0.setId(1);
		Assertions.assertEquals(1, g0.getId());
		g0.setPseudo("Julien");
		Assertions.assertEquals("Julien", g0.getPseudo());
		g0.setName("Test");
		Assertions.assertEquals("Test", g0.getName());
	}

}
