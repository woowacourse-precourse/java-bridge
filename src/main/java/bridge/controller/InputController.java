package bridge.controller;

import bridge.model.validate.BridgeSize;
import bridge.model.validate.ExitOption;
import bridge.model.validate.Stairs;
import bridge.view.InputView;

public class InputController {

	private final InputView inputView = new InputView();

	public int getBridgeSize() {
		try {
			return new BridgeSize(inputView.readBridgeSize()).getSize();
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
