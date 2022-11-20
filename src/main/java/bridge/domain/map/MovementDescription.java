package bridge.domain.map;

import bridge.domain.game.CrossingDecision;

import java.util.Arrays;

public enum MovementDescription {

	ableToCross(true, "O"),
	notAbleToCross(false, "X");

	private final boolean crossAbility;
	private final String mark;

	MovementDescription(boolean crossAbility, String mark) {
		this.crossAbility = crossAbility;
		this.mark = mark;
	}

	public static MovementDescription of(CrossingDecision crossingDecision) {
		return Arrays.stream(values())
				.filter(checkCrossable -> checkCrossable.crossAbility == crossingDecision.isCrossable())
				.findFirst()
				.orElseThrow(IllegalAccessError::new);
	}

	public String getMark() {
		return mark;
	}
}

