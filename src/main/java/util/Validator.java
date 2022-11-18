package util;

import java.util.List;

import bridgeConstant.Cell;

public class Validator {
	private static final String NUMBER_REGEX = "\\d+";
	private static final String RESTART = "R";
	private static final String QUIT = "Q";

	public static void validateBridgeSize(List<String> bridge, int size) {
		if (bridge.size() != size) {
			throw new IllegalArgumentException("[ERROR] 다리의 길이가 입력받은 길이와 같지 않습니다.");
		}
	}

	public static void validateSizeIsNumber(String number) {
		if (!number.matches(NUMBER_REGEX)) {
			throw new IllegalArgumentException("[ERROR] 다리의 길이는 숫자여야 합니다.");
		}
	}

	public static void validateMovingIsCellPosition(String moving) {
		if (!moving.equals(Cell.upPosition()) && !moving.equals(Cell.downPosition())) {
			throw new IllegalArgumentException("[ERROR] 입력은 U와 D 둘 중 하나여야 합니다.");
		}
	}

	public static void validateGameCommand(String gameCommand) {
		if (!gameCommand.equals(RESTART) && !gameCommand.equals(QUIT)) {
			throw new IllegalArgumentException("[ERROR] 입력은 R과 Q 둘 중 하나여야 합니다.");
		}
	}
}
