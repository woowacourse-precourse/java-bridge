package bridge.view;

public class InputStringValidator {
	private String INPUT_VALUE;

	public InputStringValidator(String input) {
		isValidate(input);
		this.INPUT_VALUE = input;
	}

	private void isValidate(String input){
		isEmpty(input);
		isOnlyAlphabet(input);
	}

	private void isEmpty(String input) {
		if (input.isBlank()) {
			throw new IllegalArgumentException("You should input alphabet");
		}
	}

	private void isOnlyAlphabet(String input){
		int alphabetCount = (int) input.chars()
				.filter(Character::isAlphabetic)
				.count();
		if (alphabetCount != input.length()) {
			throw new IllegalArgumentException("You should input alphabet");
		}
	}
}
