package bridge.view;

import bridge.domain.BridgeMap;
import bridge.utils.Convertor;

public class View {
	public void printBridgeMap(BridgeMap bridgeMap) {
		OutputView outputView = new OutputView();
		outputView.printMap(bridgeMap);
	}

	public void printGameResult(int tryNumber, BridgeMap bridgeMap, boolean isGameSuccess) {
		Convertor convertor = new Convertor();
		OutputView outputView = new OutputView();
		String gameSuccessOrFail = convertor.convertSuccessOrFail(isGameSuccess);
		outputView.printResult(tryNumber, bridgeMap, gameSuccessOrFail);
	}
}
