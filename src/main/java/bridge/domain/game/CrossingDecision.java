package bridge.domain.game;

import bridge.domain.player.MovementCommand;

import java.util.List;

public class CrossingDecision {

	private final boolean crossable;

	private CrossingDecision(MovementCommand movementCommand, List<String> bridge) {
		this.crossable = decideCrossable(movementCommand, bridge);
	}

	public static CrossingDecision judgingBy(MovementCommand movementCommand, List<String> bridge) {
		return new CrossingDecision(movementCommand, bridge);
	}

	private boolean decideCrossable(MovementCommand movementCommand, List<String> bridge) {
		return movementCommand.side().equals(bridge.get(0));
	}

	public boolean isCrossable() {
		return crossable;
	}
}


