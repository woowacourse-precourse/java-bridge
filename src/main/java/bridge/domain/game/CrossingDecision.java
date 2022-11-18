package bridge.domain.game;

import bridge.domain.player.Movement;

import java.util.List;

public class CrossingDecision {

	private final boolean crossable;

	private CrossingDecision(Movement movement, List<String> bridge) {
		this.crossable = decideCrossable(movement, bridge);
	}

	public static CrossingDecision judgingBy(Movement movement, List<String> bridge) {
		return new CrossingDecision(movement, bridge);
	}

	private boolean decideCrossable(Movement movement, List<String> bridge) {
		return movement.side().equals(bridge.get(0));
	}

	public boolean isCrossable() {
		return crossable;
	}
}


