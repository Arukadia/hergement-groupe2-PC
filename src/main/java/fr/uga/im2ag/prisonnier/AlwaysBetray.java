package fr.uga.im2ag.prisonnier;

public class AlwaysBetray implements Strategy {
	
	private String name = "AlwaysBetray";
	private String desc = "Always be mean";
	
    public AlwaysBetray() {
	}
    
    @Override
    public Actions getAction(Turn[] turns, int player) {
    	return Actions.T;
    }
    
    public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}
}
