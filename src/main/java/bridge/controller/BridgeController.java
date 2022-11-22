package bridge.controller;

import bridge.domain.game.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeController {
	int numberOfAttempts = 0; //시도한 횟수
	String successGame = "실패";
	String map;

	OutputView outputView = new OutputView();
	InputView inputView = new InputView();
	BridgeGame bridgeGame = new BridgeGame();
	List<String> moves = new ArrayList<>();


	public void run(){
		outputView.printStartGame();
		List<String> bridges = makeBridge();
	}

	public List<String> makeBridge(){
		int size = askBridgeSize();
		List<String> bridges = bridgeGame.makeBridge(size);
		return bridges;

	}
	public int askBridgeSize() {
		while (true){
			try {
				outputView.printSizeSelect();
				return inputView.readBridgeSize();
			}catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}
}
