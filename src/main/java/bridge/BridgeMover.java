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

	public boolean checkMovable(List<String> bridgeColumns, String mark, int moveCount) {
		return bridgeColumns.get(moveCount).equals(mark);
	}

	private void validateMarkIsInRange(String markToMove) throws IllegalArgumentException {
		if (!BridgeNumber.isExistedMark(markToMove)) {
			throw new IllegalArgumentException(BRIDGE_MARK_TO_MOVE_IS_NOT_IN_RANGE);
		}
	}

	public void printBridgeMap(List<String> bridgeColumns, int moveCount, boolean movable) {
		outputView.printMap(bridgeColumns, moveCount, movable);
	}
}
