package bridge.Validation;

public class Validation {
	private static String NUMBER_ONLY_EXCEPTION_MESSAGE = "[ERROR] 숫자만 입력해주세요.";

	public static void validateNumberOnly(String input) {

		try {
			Integer.parseInt(input);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(NUMBER_ONLY_EXCEPTION_MESSAGE);
		}
	}
}
