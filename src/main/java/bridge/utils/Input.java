package bridge.utils;

import bridge.domain.dto.BridgeSize;
import bridge.domain.dto.GameCommand;
import bridge.domain.dto.Moving;
import bridge.view.InputView;

public class Input {
	private final InputView inputView = new InputView();

	public BridgeSize bridgeSize() {
		while (true) {
			try {
				String inputSize = inputView.readBridgeSize();
				System.out.println();
				return new BridgeSize(inputSize);
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	public Moving moving() {
		while (true) {
			try {
				String inputMoving = inputView.readMoving();
				return new Moving(inputMoving);
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	public GameCommand gameCommand() {
		while (true) {
			try {
				String inputGameCommand = inputView.readGameCommand();
				return new GameCommand(inputGameCommand);
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}
}
