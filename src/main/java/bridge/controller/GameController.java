package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

	private final BridgeGame game;
	private final InputView inputView;
	private final OutputView outputView;

	public GameController() {
		inputView = new InputView();
		outputView = new OutputView();

		outputView.printStart();
		game = new BridgeGame(inputView.readBridgeSize());
	}

	public void play() {
		while (!tryMove());

		outputView.printResult(game.getRecord(), game.isFinish());
	}

	private boolean tryMove() {
		boolean success = game.move(inputView.readMoving());

		if (success) {
			outputView.printMap(game.getRecord().getBoards());
			return game.isFinish();
		} else if (!success) {
			outputView.printMap(game.getRecord().getBoards());
			return game.retry(inputView.readGameCommand());
		}
		return false;
	}

}
