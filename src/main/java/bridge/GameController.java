package bridge;

import static bridge.Constants.*;

import java.util.HashMap;

public class GameController {
	HashMap<String, String> status;

	public GameController() {
		OutputView.printStartGameMessage();
		int bridgeSize = InputController.getBridgeSize();
		OutputView.printNewLine();

		BridgeRandomNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);

		Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
		BridgeGame bridgeGame = new BridgeGame(bridge, bridgeSize);

		while (!bridgeGame.isEnd()) {
			String userSelectCell = InputController.getMoving();
			String bridgeLetter = bridgeGame.getBridgeLetter();
			bridgeGame.move(userSelectCell);
			status = OutputView.printMap(userSelectCell, bridgeLetter);
			OutputView.printStatus(status);
			OutputView.printNewLine();
			if (Pause.isPaused()) {
				String userSelectCommand = InputController.getGameCommand();
				if (userSelectCommand.equals(RESTART)) {
					bridgeGame.retry();
					OutputView.resetStatus();
				}
				if (userSelectCommand.equals(QUIT)) {
					bridgeGame.end();
				}
			}
		}

		OutputView.printFinalGameResultMessage();
		status = OutputView.printResult();
		OutputView.printStatus(status);
		OutputView.printNewLine();
		OutputView.printGameReportMessage();
		OutputView.printTotalTryCountMessage();
	}
}
