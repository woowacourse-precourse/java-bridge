package bridge.controller;

import static bridge.controller.Constant.*;

import java.util.List;

import bridge.view.InputView;
import bridge.view.OutputView;

public class ControllerV2 {
	private BridgeGame game;
	private List<String> state;
	private String command = "";
	private int size;
	private boolean retry = true;
	private boolean winOrLose = false;
	private final String WRONG_ANSWER = "X";

	public void init() {
		OutputView.printStartMessage();
		this.size = InputView.readBridgeSize();
		this.game = new BridgeGame(size);
	}

	public void run() {
		int index = 0;
		do {
			index = gameState(index);
			if (retryLogic()) {
				break;
			}
			isWin(index);
		} while (retry);
	}

	public void end() {
		OutputView.printResult(state, game.getTryCount(), winOrLose);
	}

	private int gameState(int index) {
		String location = InputView.readMoving();
		state = this.game.move(location, index);
		index++;
		OutputView.printMap(state);
		return index;
	}

	private void isWin(int index) {
		if (index == size) {
			this.retry = false;
			this.winOrLose = true;
		}
	}

	private boolean retryLogic() {
		if (state.get(0).contains(WRONG_ANSWER) || state.get(1).contains(WRONG_ANSWER)) {
			command = InputView.readGameCommand();
			isRetry();
			if (isQuit())
				return true;
		}
		return false;
	}

	private void isRetry() {
		if (command.equals(RETRY_GAME)) {
			this.game.retry();
			run();
		}
	}

	private boolean isQuit() {
		if (command.equals(QUIT_GAME)) {
			this.retry = false;
			return true;
		}
		return false;
	}
}
