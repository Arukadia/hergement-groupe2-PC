package fr.uga.im2ag.prisonnier;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestPlayer {

	
	
	@Test
	void Test_Getters() {
		Player p1 = new Player();
		Assertions.assertEquals(null, p1.getPseudo());
		Player p0 = new Player("Guillaume");
		Assertions.assertEquals("Guillaume", p0.getPseudo());
	}
	
	@Test
	void Test_Setters() {
		Player p0 = new Player("Guillaume");
		p0.setPseudo("Julien");
		Assertions.assertEquals("Julien", p0.getPseudo());
	}
	
	@Test
	void Test_CreateGame() {
		Player p0 = new Player("Guillaume");
		Game g0 = p0.createGame(5);
		Assertions.assertEquals(g0.getPlayerOne(),p0);
	}
	
	@Test
	void Test_JoinGame() {
		Player p0 = new Player("Guillaume");
		Player p1 = new Player("Julien");
		Game g0 = new Game(5,p0);
		p1.joinGame(g0);
		Assertions.assertEquals(g0.getPlayerTwo(),p1);
	}
	
	@Test
	void Test_LeaveGame() {
		Player p0 = new Player("Guillaume");
		Player p1  = new Player("Julien");
		Game g0 = new Game(5,p0);
		p1.joinGame(g0);
		p1.leaveGame(g0);
		Assertions.assertEquals(null, g0.getPlayerTwo());		
		p0.leaveGame(g0);
		Assertions.assertEquals(null, g0.getPlayerOne());
	}

}
