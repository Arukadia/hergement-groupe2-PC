package fr.uga.im2ag.prisonnier;

public interface Strategy {
	
	public Actions getAction(Turn[] turns, int player);
}
