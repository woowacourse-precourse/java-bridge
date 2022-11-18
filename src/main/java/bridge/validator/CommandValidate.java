package bridge.validator;

public class CommandValidate {

	public static void validateCharacter(String input) {
		if (input.length() != 1) {
			throw new IllegalArgumentException("여러 개의 문자를 입력할 수 없습니다.");
		}
	}

	public static void validateEnglish(String input) {
		if (!input.matches("^[a-zA-Z]+$")) {
			throw new IllegalArgumentException("영어만 입력할 수 있습니다.");
		}
	}

	public static void validateUpperCase(String input) {
		if (!input.matches("^[A-Z]+$")) {
			throw new IllegalArgumentException("대문자만 입력할 수 있습니다.");
		}
	}

	public static void validateExactCharacterUD(String input) {
		if (!input.matches("^[UD]+$")) {
			throw new IllegalArgumentException("U와 D만 입력할 수 있습니다.");
		}
	}

	public static void validateExactCharacterRQ(String input) {
		if (!input.matches("^[RQ]+$")) {
			throw new IllegalArgumentException("R과 Q만 입력할 수 있습니다.");
		}
	}
}
