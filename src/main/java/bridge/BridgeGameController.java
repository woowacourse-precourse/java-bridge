package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.Record;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
	private static final Boolean WIN = true;
	private static final Boolean LOSE = false;
	private final BridgeGame bridgeGame;
	private final InputView inputView = new InputView();
	private final OutputView outputView = new OutputView();

	BridgeGameController() {
		outputView.printStart();
		BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
		this.bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
	}

	public void gameStart(int repeat) {
		Record record = new Record();
		crossTheBridge(record);
		if (judgeGameResult(repeat, record) == WIN) {
			return;
		}
		gameRestartOrQuit(repeat, record);
	}

	private void crossTheBridge(Record record) {
		for (int bridgeIndex = 0; bridgeIndex < bridgeGame.getBridgeSize(); bridgeIndex++) {
			crossOneStep(record, bridgeIndex);
			outputView.printMap(record.getMap());
			if (!isSuccess(record)) {
				break;
			}
		}
	}

	private void crossOneStep(Record record, int bridgeIndex) {
		String move = decideUpOrDown();
		Boolean resultOfMove = bridgeGame.move(move, bridgeIndex);
		record.recordOneMove(move, resultOfMove);
	}

	private boolean judgeGameResult(int repeat, Record record) {
		if (isSuccess(record)) {
			gameEnd(record, repeat);
			return WIN;
		}
		return LOSE;
	}

	private void gameRestartOrQuit(int repeat, Record record) {
		if (isQuit()) {
			gameEnd(record, repeat);
			return;
		}
		gameStart(repeat + 1);
	}

	private void gameEnd(Record record, int repeat) {
		outputView.printResult(record.getMap(), record.isSuccess(), repeat);
	}

	private String decideUpOrDown() {
		return inputView.readMoving();
	}

	private static boolean isSuccess(Record record) {
		return record.isSuccess();
	}

	private boolean isQuit() {
		return !bridgeGame.retry(inputView.readGameCommand());
	}
}
