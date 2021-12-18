package fr.uga.im2ag.prisonnier;

public class GiveAndTake implements Strategy {

	private String name = "GiveAndTake";
	private String desc = "Play like your opponent";

	public GiveAndTake() {
	}

	@Override
	public Actions getAction(Turn[] turns, int player) {

		for (int i = 0; i < turns.length; i++) {
			if (i == 0) {
				if (turns[i].getActionP1() == Actions.NULL && turns[i].getActionP2() == Actions.NULL) {
					return Actions.C;
				}
			} else {
				if (turns[i].getActionP1() == Actions.NULL && turns[i].getActionP2() == Actions.NULL) {
					if (player == 0) {
						return turns[i - 1].getActionP2();
					} else {
						return turns[i - 1].getActionP1();
					}
				}
			}
		}
		return Actions.NULL;

	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}
}
