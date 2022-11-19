package controller;

import bridge.InputView;
import bridge.OutputView;

public class BridgeController {
	private final OutputView outputView = new OutputView();
	private final InputView inputView = new InputView();

	public void BridgeGameStart(){
		outputView.printStartGame();

		int bridgeSize = inputView.readBridgeSize();
		if(bridgeSize==0){
			throw new IllegalStateException("[ERROR] 예기치 못한 에러를 만났습니다.");
		}

	}

}
