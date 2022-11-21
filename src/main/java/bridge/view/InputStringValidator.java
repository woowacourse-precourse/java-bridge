package bridge.view;

import bridge.Util;

import java.util.List;

public class InputStringValidator {
	private final String INPUT_VALUE;
	private final int VALIDATE_SIZE = 1;

	public InputStringValidator(String input) {
		isValidate(input);
		this.INPUT_VALUE = input;
	}

	private void isValidate(String input){
		isEmpty(input);
		isLengthOne(input);
		isOnlyAlphabet(input);
	}

	private void isEmpty(String input) {
		if (input.isBlank()) {
			throw new IllegalArgumentException("You should input alphabet");
		}
	}

	private void isLengthOne(String input) {
		if (input.length() != VALIDATE_SIZE) {
			throw new IllegalArgumentException("It is illegal size");
		}
	}

	private void isOnlyAlphabet(String input){
		if (!Character.isAlphabetic(input.charAt(0))) {
			throw new IllegalArgumentException("You should input alphabet");
		}
	}

	public void isValidateAlphabet(List<String> validateAlphabets){
		if (!validateAlphabets.contains(INPUT_VALUE)) {
			throw new IllegalArgumentException("It is illegal Alphabet");
		}
	}

	public String getInputValue() {
		return INPUT_VALUE;
	}
}
