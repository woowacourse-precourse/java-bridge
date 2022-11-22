package bridge.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView implements ConsoleInput, InputValidator {

	private final String input;

	public InputView() {
		this.input = consoleRead();
	}

	@Override
	public String consoleRead() {
		String input = Console.readLine().trim();
		validate(input);
		return input;
	}

	@Override
	public void validate(String input) {
		if (input.equals("")) {
			throw new InputException(InputException.EMPTY);
		}
	}

	@Override
	public void validate(Integer value) {
	}

	public String input() {
		return this.input;
	}
}
