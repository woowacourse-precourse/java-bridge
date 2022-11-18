package util;

import java.util.List;

import bridgeConstant.Cell;

public class Validator {
	private static final String NUMBER_REGEX = "\\d+";

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

	public static void validateCellPosition(String position) {
		if (!position.equals(Cell.upPosition()) && !position.equals(Cell.downPosition())) {
			throw new IllegalArgumentException("[ERROR] 이동할 칸은 U와 D 둘 중 하나여야 합니다.");
		}
	}
}
