package bridge.utils.Controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.GameCounter;
import bridge.domain.dto.BridgeSize;
import java.util.List;

public class GameController {
	private final boolean GAME_SUCCESS = true;
	private final boolean GAME_FAIL = false;
	private ViewController viewController = new ViewController();
	private InputController inputController = new InputController();
	private GameCounter gameCounter;
	private BridgeGame bridgeGame;

	public void start() {
		try {
			Bridge bridge = createBridge();
			bridgeGame = new BridgeGame(bridge);
			gameCounter = new GameCounter();
			play();
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return;
		}
	}

	private Bridge createBridge() {
		viewController.startBridgeGame();
		BridgeSize bridgeSize = inputController.getBridgeSize();
		BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
		List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getSize());
		return new Bridge(bridge);
	}

	private void play() {
		gameCounter.addCount();
		boolean gameResult = getGameResult();
		gameOverOrRetry(gameResult);
	}

	private boolean getGameResult() {
		while (!bridgeGame.keepMove()) {
			boolean movingResult = bridgeGame.move();
			viewController.printBridgeMap(bridgeGame.getBridgeMap());
			if (!movingResult) {
				return false;
			}
		}
		return true;
	}

	private void gameOverOrRetry(boolean gameResult) {
		if (gameResult) {
			gameOver();
		}
		if (!gameResult) {
			gameRestartOrQuit(bridgeGame.retry());
		}
	}

	private void gameOver() {
		viewController.printGameResult(gameCounter.getCount(), bridgeGame.getBridgeMap(), GAME_SUCCESS);
	}

	private void gameRestartOrQuit(boolean isRetry) {
		if (isRetry) {
			bridgeGame.resetGame();
			play();
		}
		if (!isRetry) {
			viewController.printGameResult(gameCounter.getCount(), bridgeGame.getBridgeMap(), GAME_FAIL);
		}
	}
}
