package util;

import java.util.List;

import bridgeConstant.Cell;
import bridgeConstant.Constant;

public class Validator {
	private static final String NUMBER_REGEX = "\\d+";

	private static final int SIZE_LOWER_INCLUSIVE = 3;
	private static final int SIZE_UPPER_INCLUSIVE = 20;

	public static void validateBridgeSize(List<String> bridge, int size) {
		if (bridge.size() != size) {
			throw new IllegalArgumentException("[ERROR] 다리의 길이가 입력받은 길이와 같지 않습니다.");
		}
	}

	public static void validateBridgeSizeRange(int size) {
		if (size < SIZE_LOWER_INCLUSIVE || size > SIZE_UPPER_INCLUSIVE) {
			throw new IllegalArgumentException("[ERROR] 다리의 길이는 3부터 20 사이여야 합니다.");
		}
	}

	public static void validateSizeIsNaturalNumber(String number) {
		if (!number.matches(NUMBER_REGEX)) {
			throw new IllegalArgumentException("[ERROR] 다리의 길이는 자연수여야 합니다.");
		}
	}

	public static void validateMovingIsCellPosition(String moving) {
		if (!moving.equals(Constant.UPPER_POSITION) && !moving.equals(Constant.LOWER_POSITION)) {
			throw new IllegalArgumentException("[ERROR] 입력은 U와 D 둘 중 하나여야 합니다.");
		}
	}

	public static void validateGameCommand(String gameCommand) {
		if (!gameCommand.equals(Constant.RESTART) && !gameCommand.equals(Constant.QUIT)) {
			throw new IllegalArgumentException("[ERROR] 입력은 R과 Q 둘 중 하나여야 합니다.");
		}
	}

	public static void validateBridgeComponent(List<String> bridge) {
		if (bridge.stream().anyMatch(cell -> !cell.equals(Constant.UPPER_POSITION) && !cell.equals(Constant.LOWER_POSITION))) {
			throw new IllegalArgumentException("[ERROR] 다리는 U와 D로 이루어져야 합니다.");
		}
	}
}
