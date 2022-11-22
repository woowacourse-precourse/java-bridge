package bridge.validator;

import static bridge.util.Constants.*;
import static bridge.util.Message.*;

public class CommandValidate {

	public static void validateCharacter(String input) {
		if (isMultipleWords(input)) {
			throw new IllegalArgumentException(ERROR_ONE_CHARACTER);
		}
	}

	private static boolean isMultipleWords(String input) {
		return input.length() != 1;
	}

	public static void validateEnglish(String input) {
		if (!input.matches(ENGLISH_ONLY)) {
			throw new IllegalArgumentException(ERROR_ENGLISH_ONLY);
		}
	}

	public static void validateUpperCase(String input) {
		if (!input.matches(UPPERCASE_ONLY)) {
			throw new IllegalArgumentException(ERROR_UPPERCASE_ONLY);
		}
	}

	public static void validateExactCharacterUD(String input) {
		if (!input.matches(UD_ONLY)) {
			throw new IllegalArgumentException(ERROR_UD_ONLY);
		}
	}

	public static void validateExactCharacterRQ(String input) {
		if (!input.matches(RQ_ONLY)) {
			throw new IllegalArgumentException(ERROR_RQ_ONLY);
		}
	}
}
