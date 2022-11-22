package bridge.utils.Controller;

import bridge.domain.BridgeMap;
import bridge.utils.Convertor;
import bridge.view.InputView;
import bridge.view.OutputView;

public class ViewController {
	private OutputView outputView = new OutputView();
	private Convertor convertor = new Convertor();
	private InputView inputView = new InputView();

	public void startBridgeGame() {
		inputView.startGame();
	}

	public void printBridgeMap(BridgeMap bridgeMap) {
		outputView.printMap(bridgeMap);
	}

	public void printGameResult(int tryNumber, BridgeMap bridgeMap, boolean isGameSuccess) {
		String gameSuccessOrFail = convertor.convertSuccessOrFail(isGameSuccess);
		outputView.printResult(tryNumber, bridgeMap, gameSuccessOrFail);
	}
}
