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

	public void play(){
		game.start(inputView, outputView);
	}

}
