package fr.uga.im2ag.prisonnier;

public class AlwaysCoop implements Strategy {
	
	private String name = "AlwaysCoop";
	private String desc = "Always be nice";
	
    public AlwaysCoop() {
	}
    
    @Override
    public Actions getAction(Turn[] turns, int player) {
    	return Actions.C;
    }
    
    public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}
}
