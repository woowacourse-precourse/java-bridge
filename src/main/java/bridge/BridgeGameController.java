package bridge;

import bridge.domain.Record;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
	private final BridgeGame bridgeGame;
	private final InputView inputView;
	private final OutputView outputView;

	BridgeGameController() {
		this.outputView = new OutputView();
		this.inputView = new InputView();
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		this.bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
	}

	public void gameStart() {
		Record record = new Record();
		Boolean gameResult = true;
		for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
			String move = inputView.readMoving();
			gameResult = bridgeGame.move(move, i);
			record.recordResult(move, gameResult);
			outputView.printMap(record.getResult());
			if (gameResult == false) {
				if (bridgeGame.retry(inputView.readGameCommand())) {
					gameStart();
				}
				break;
			}
		}
		if (gameResult == true) {
			gameEnd(record);
		}
	}

	private void gameEnd(Record record) {
		outputView.printResult(record.getResult());
	}
}
