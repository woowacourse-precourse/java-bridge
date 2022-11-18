package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class GameController {

	private final BridgeGame game;

	public GameController() {
		game = new BridgeGame();
	}

	public void play(){
		game.start();
		game.move();
	}

}
