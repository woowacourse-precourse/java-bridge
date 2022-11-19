package controller;

import bridge.InputView;
import bridge.OutputView;

public class BridgeController {
	private final OutputView outputView = new OutputView();
	private final InputView inputView = new InputView();

	public void BridgeGameStart(){
		outputView.printStartGame();



	}

}
