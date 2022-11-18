package util;

import java.util.List;

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
}
