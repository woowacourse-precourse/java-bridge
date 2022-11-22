package bridge.utils.Controller;

import bridge.domain.dto.BridgeSize;
import bridge.domain.dto.GameCommand;
import bridge.domain.dto.Moving;
import bridge.view.InputView;

public class InputController {
	private final InputView inputView = new InputView();

	public BridgeSize getBridgeSize() {
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

	public Moving getMoving() {
		while (true) {
			try {
				String inputMoving = inputView.readMoving();
				return new Moving(inputMoving);
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
	}

	public GameCommand getGameCommand() {
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
