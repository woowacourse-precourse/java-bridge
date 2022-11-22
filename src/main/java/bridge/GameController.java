package bridge;

import bridge.BridgeGame;
import bridge.InputView;

public class GameController {
	static void bridgeGameStart(BridgeGame game) {
		while (true) {
			while (!game.gameOver && !game.completeBridge) {
				String moving = InputView.readMoving();
				game.move(moving);
			}
			if (game.completeBridge) {break;}
			if (afterGameOver(game)) {break;}
		}
	}

	private static boolean afterGameOver(BridgeGame game) {
		String restart = InputView.readGameCommand();
		game.retry(restart);
		if (game.retry) {
			game.gameOver = false;
		}
		return !game.retry;
	}
}
