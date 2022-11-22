package bridge.io;

public class InputNumValidator {
	private String INPUT_VALUE;

	public InputNumValidator(String input) {
		isValidate(input);
		this.INPUT_VALUE = input;
	}

	private void isValidate(String input) {
		isEmpty(input);
		isOnlyNumber(input);
	}

	private void isEmpty(String input) {
		if (input.isBlank()) {
			throw new IllegalArgumentException("You should input number");
		}
	}

	private void isOnlyNumber(String input) {
		input.chars()
				.forEach(word -> throwIfNotDigit((char)word));
	}

	private static void throwIfNotDigit(char ch) {
		if (!Character.isDigit(ch)) {
			throw new IllegalArgumentException("It is not number");
		}
	}

	public int getInputValue(){
		return Integer.parseInt(INPUT_VALUE);
	}
}
