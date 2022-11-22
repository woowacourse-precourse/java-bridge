package bridge;

import static bridge.constant.ErrorMessage.*;

import bridge.domain.BridgeColumn;
import bridge.domain.GameState;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeMover {

	private final OutputView outputView;

	public BridgeMover() {
		outputView = new OutputView();
	}

	public String inputBridgeMarkToMove() {
		outputView.printRequestBridgeMarkToMove();
		while (true) {
			String markToMove = new InputView().readMoving();
			try {
				validateMarkIsInRange(markToMove);
				return markToMove;
			} catch (IllegalArgumentException exception) {
				outputView.printErrorMessage(exception);
			}
		}
	}

	private void validateMarkIsInRange(String markToMove) throws IllegalArgumentException {
		if (!BridgeColumn.isExistedMark(markToMove)) {
			throw new IllegalArgumentException(BRIDGE_MARK_TO_MOVE_IS_NOT_IN_RANGE);
		}
	}

	public void printBridgeResultMap() {
		outputView.printMap(BridgeColumn.getResultMapAsString());
	}

	public boolean askRetry() {
		outputView.printRequestRetryCommand();
		while(true) {
			String command = new InputView().readGameCommand();
			try {
				validateRetryCommand(command);
				return GameState.isRetryCommand(command);
			} catch (IllegalArgumentException exception) {
				outputView.printErrorMessage(exception);
			}
		}
	}

	private void validateRetryCommand(String command) {
		if(!GameState.isExistedCommand(command)) {
			throw new IllegalArgumentException(RETRY_COMMAND_IS_NOT_IN_RANGE);
		}
	}
}
