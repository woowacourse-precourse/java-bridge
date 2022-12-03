package bridge.utils.Controller;

import bridge.Bridge;
import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.GameCounter;
import bridge.User;
import bridge.dto.BridgeSize;
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
			setUp();
			play();
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return;
		}
	}

	private void setUp() {
		Bridge bridge = createBridge();
		User user = new User(bridge);
		bridgeGame = new BridgeGame(user);
		gameCounter = new GameCounter();
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
