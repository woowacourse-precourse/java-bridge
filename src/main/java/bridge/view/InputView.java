package bridge.view;

import bridge.domain.player.BridgeSize;
import bridge.domain.player.GameProceedCommand;
import bridge.domain.player.MovementCommand;
import camp.nextstep.edu.missionutils.Console;

public class InputView implements ConsoleInput, InputValidator {

	public BridgeSize readBridgeSize() {
		try {
			return BridgeSize.valueOf(input());
		} catch (IllegalArgumentException ignored) {
			return readBridgeSize();
		}
	}

	public MovementCommand readMovement() {
		try {
			return MovementCommand.valueOf(input());
		} catch (IllegalArgumentException ignored) {
			return readMovement();
		}
	}

	public GameProceedCommand readGameCommand() {
		try {
			return GameProceedCommand.valueOf(input());
		} catch (IllegalArgumentException ignored) {
			return readGameCommand();
		}
	}

	@Override
	public String input() {
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
}
