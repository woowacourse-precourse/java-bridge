package bridge;

import static bridge.constant.ErrorMessage.BRIDGE_MARK_TO_MOVE_IS_NOT_IN_RANGE;

import bridge.domain.BridgeNumber;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeMover {

	private static OutputView outputView;

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
		if (!BridgeNumber.isExistedMark(markToMove)) {
			throw new IllegalArgumentException(BRIDGE_MARK_TO_MOVE_IS_NOT_IN_RANGE);
		}
	}

	public void printBridgeResultMap() {
		outputView.printMap(BridgeNumber.getResultMapAsString());
	}

	private void validateRetryCommand() {

	}
}
