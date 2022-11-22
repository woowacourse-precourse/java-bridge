package bridge.validator;

import static bridge.Constants.*;
import static bridge.Message.*;

public class CommandValidate {

	public static void validateCharacter(String input) {
		if (input.length() != 1) {
			throw new IllegalArgumentException(ERROR_ONE_CHARACTER);
		}
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
