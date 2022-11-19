package bridge;

import bridge.domain.Record;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
	private final BridgeGame bridgeGame;
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	BridgeGameController() {
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		this.bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
	}

	public void gameStart(int repeat) {
		Record record = new Record();
		crossTheBridge(record);
		if (isFall(record)) {
			if (isRetry()) {
				gameStart(repeat + 1);
				return;
			}
		}
		gameEnd(record, repeat);
	}

	private boolean isRetry() {
		return bridgeGame.retry(inputView.readGameCommand());
	}

	private static boolean isFall(Record record) {
		return !record.isSuccess();
	}

	private void crossTheBridge(Record record) {
		for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
			crossOneStep(record, i);
			outputView.printMap(record.getResult());
			if (!record.isSuccess()) {
				break;
			}
		}
	}

	private void crossOneStep(Record record, int i) {
		String move = decideUpOrDown();
		Boolean resultOfMove = bridgeGame.move(move, i);
		record.recordOneMove(move, resultOfMove);
	}

	private String decideUpOrDown() {
		return inputView.readMoving();
	}

	private void gameEnd(Record record, int repeat) {
		outputView.printResult(record.getResult(), repeat);
	}
}
