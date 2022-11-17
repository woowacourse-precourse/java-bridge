package bridge.controller;

import bridge.model.BridgeSize;
import bridge.model.ExitOption;
import bridge.model.Stairs;
import bridge.view.InputView;

public class InputController {

	private static final InputView inputView = new InputView();

	public static int getBridgeSize() {
		try {
			return new BridgeSize(inputView.readBridgeSize()).getSize();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getBridgeSize();
		}
	}

	public static Stairs getStairs() {
		try {
			return Stairs.of(inputView.readMoving());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getStairs();
		}
	}

	public static String getExitOption() {
		try {
			return ExitOption.of(inputView.readGameCommand()).getCommand();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getExitOption();
		}
	}
}
