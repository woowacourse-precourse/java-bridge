package bridge;

import bridge.domain.BridgeColumn;
import bridge.view.OutputView;

public class BridgeGameResult {
	public void printGameResult(boolean success, int gamePlayCount) {
		new OutputView().printResult(BridgeColumn.getResultMapAsString(), success, gamePlayCount);
	}
}
