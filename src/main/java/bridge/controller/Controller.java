package bridge.controller;

import static bridge.controller.Constant.*;

import java.util.List;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
	private BridgeGame game;
	List<String> state;
	private String command = "";
	private int size;

	public void init() {
		OutputView.printStartMessage();
		this.size = InputView.readBridgeSize();
		this.game = new BridgeGame(size);
	}

	public void play(BridgeGame game) {
		logic(game);
		OutputView.printResultWin(state, game.getTryCount());
	}

	private void logic(BridgeGame game) {
		for (int i = 0; i < size; i++) {
			String location = InputView.readMoving();
			state = game.move(location, i);
			OutputView.printMap(state);
			if (game.checkRetry()) {
				command = InputView.readGameCommand();
				retryLogic(game);
			}
		}
	}

	private void retryLogic(BridgeGame game) {
		if (command.equals(RETRY_GAME)) {
			game.retry();
			play(this.game);
		}
		if (command.equals(QUIT_GAME)) {
			OutputView.printResultLose(state, game.getTryCount());
		}
	}

	public BridgeGame getGame() {
		return game;
	}
}
