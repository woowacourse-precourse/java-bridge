package bridge;

import javax.swing.text.StyledEditorKit;

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

	public void gameStart(int repeat) {
		Record record = new Record();
		Boolean gameResult = true;
		for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
			String move = inputView.readMoving();
			gameResult = bridgeGame.move(move, i);
			record.recordResult(move, gameResult);
			outputView.printMap(record.getResult());
			if (gameResult == false) {
				Boolean isRetry = bridgeGame.retry(inputView.readGameCommand());
				if (isRetry) {
					gameStart(repeat + 1);
				}
				if (!isRetry) {
					gameEnd(record, repeat);
				}
				break;
			}
		}
		if (gameResult == true) {
			gameEnd(record, repeat);
		}
	}

	private void gameEnd(Record record, int repeat) {
		outputView.printResult(record.getResult(), repeat);
	}
}
