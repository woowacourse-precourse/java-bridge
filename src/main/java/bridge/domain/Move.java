package bridge.domain;

import java.util.Arrays;

public enum Move {
	DOWN(0, "D"),
	UP(1, "U");

	private static final String NOT_MOVING_COMMAND = "[ERROR] 이동할 칸의 입력은 U 또는 D으로 입력을 해야합니다.";
	private static final String NOT_MOVING_NUMBER = "[ERROR] 아래칸과 위 칸에 해당하는 랜덤 숫자가 아닙니다.";

	private final int moveNumber;
	private final String moveCommand;

	Move(int moveNumber, String moveCommand) {
		this.moveCommand = moveCommand;
		this.moveNumber = moveNumber;
	}

	public int getMoveNumber() {
		return moveNumber;
	}

	public String getMoveCommand() {
		return moveCommand;
	}

	public static Move find(String command) {
		return Arrays.stream(values())
			.filter(move -> command.equals(move.getMoveCommand()))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(NOT_MOVING_COMMAND));
	}

	public static Move find(int number) {
		return Arrays.stream(values())
			.filter(move -> number == move.getMoveNumber())
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException(NOT_MOVING_NUMBER));
	}
}
