package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

	private final BridgeGame game;
	private final InputView inputView;
	private final OutputView outputView;

	public GameController() {
		game = new BridgeGame();
		inputView = new InputView();
		outputView = new OutputView();
	}

	public void play() {
		outputView.printStart();
		game.start(inputView.readBridgeSize());

		while (!tryMove());

		outputView.printResult(game.getRecord(), game.isFinish());
	}

	private boolean tryMove() {
		boolean isEnd = false;
		boolean success = game.move(inputView.readMoving());

		if (success) {
			outputView.printMap(game.getRecord().getBoards());
			isEnd = game.isFinish();
		} else if (!success) {
			outputView.printMap(game.getRecord().getBoards());
			isEnd = game.retry(inputView.readGameCommand());
		}

		return isEnd;
	}

}
