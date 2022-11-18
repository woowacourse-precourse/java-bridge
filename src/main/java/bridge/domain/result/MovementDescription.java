package bridge.domain.result;

import bridge.domain.game.CrossingDecision;

import java.util.Arrays;

public enum MovementDescription {
	go(true, "O"),
	stop(false, "X");

	private final boolean passAllowance;
	private final String mark;

	MovementDescription(boolean passAllowance, String mark) {
		this.passAllowance = passAllowance;
		this.mark = mark;
	}

	public static MovementDescription of(CrossingDecision crossingDecision) {
		return Arrays.stream(values())
				.filter(checkPassable -> checkPassable.passAllowance == crossingDecision.isCrossable())
				.findFirst()
				.orElseThrow(IllegalAccessError::new);
	}

	public String getMark() {
		return mark;
	}
}

