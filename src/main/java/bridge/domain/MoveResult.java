package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import bridge.domain.command.MoveCommand;

public enum MoveResult {
	MOVE_SUCCESS("O"),
	MOVE_FAILED("X"),
	NO_MOVE(" ");

	private final String result;

	MoveResult(String result) {
		this.result = result;
	}

	public static List<String> createMoveResult(String moving, boolean isCorrectMove) {
		if (isCorrectMove) {
			return correctMove(moving);
		}
		return incorrectMove(moving);
	}

	private static List<String> correctMove(String moving) {
		if (moving.equals(MoveCommand.MOVE_UP.getValue())) {
			return List.of(MOVE_SUCCESS.result, NO_MOVE.result);
		}
		return new ArrayList<>(List.of(NO_MOVE.result, MOVE_SUCCESS.result));
	}

	private static List<String> incorrectMove(String moving) {
		if (moving.equals(MoveCommand.MOVE_UP.getValue())) {
			return new ArrayList<>(List.of(MOVE_FAILED.result, NO_MOVE.result));
		}
		return new ArrayList<>(List.of(NO_MOVE.result, MOVE_FAILED.result));
	}
}
