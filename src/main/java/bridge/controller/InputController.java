package bridge.controller;

import bridge.model.validation.BridgeSize;
import bridge.model.validation.ExitOption;
import bridge.model.validation.Stairs;
import bridge.view.InputView;

public class InputController {

	private final InputView inputView = new InputView();

	public int getBridgeSize() {
		try {
			return BridgeSize.validateRange(inputView.readBridgeSize());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getBridgeSize();
		}
	}

	public Stairs getStairs() {
		try {
			return Stairs.of(inputView.readMoving());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getStairs();
		}
	}

	public ExitOption getExitOption() {
		try {
			return ExitOption.of(inputView.readGameCommand());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getExitOption();
		}
	}
}
