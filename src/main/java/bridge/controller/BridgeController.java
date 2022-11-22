package bridge.controller;

import bridge.domain.game.BridgeGame;
import bridge.domain.result.BridgeResult;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class BridgeController {

	OutputView outputView;
	InputView inputView;
	BridgeGame bridgeGame;
	BridgeResult bridgeResult;
	List<String> moves = new ArrayList<>();

	public BridgeController() {
		this.outputView = new OutputView();
		this.inputView = new InputView();
		this.bridgeGame = new BridgeGame();
	}


	public void run() {
		outputView.printStartGame();
		List<String> bridges = makeBridge();
		play(bridges);
		result();

	}

	public List<String> makeBridge() {
		int size = askBridgeSize();
		List<String> bridges = bridgeGame.makeBridge(size);
		bridgeResult = new BridgeResult(bridges);
		return bridges;

	}

	public int askBridgeSize() {
		while (true) {
			try {
				return inputView.readBridgeSize();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void play(List<String> bridges) {
		String map = "";
		int index;
		for (index = 0; index < bridges.size(); index++) {
			String moveCommand = askMove();
			bridgeResult.addMaps(moveCommand,index);
			boolean isRightMove = bridgeGame.move(bridges, moveCommand, index);
			outputView.printMap(bridgeResult);
			index = retry(isRightMove, index);
		}
		updateResult(bridges,index, map);
	}
	public int retry(boolean isRightmove, int index) {
		if (!isRightmove) {
			index = askRetry();
			bridgeResult.addCountOfAttemps(index);
			bridgeResult.init();
		}
		return index;
	}

	public void updateResult(List<String> bridges, int moveIndex, String map) {
		if (moveIndex == bridges.size()) {
			bridgeResult.gameSuccess();
		}
	}


	public String askMove() {
		while (true) {
			try {
				String moveCommand = inputView.readMoving();
				moves.add(moveCommand);
				return moveCommand;
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public int askRetry() {
		try {
			String command = inputView.readGameCommand();
			moves.clear();
			return bridgeGame.retry(command);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return askRetry();
		}
	}
	public void result() {
		outputView.printResult(bridgeResult);
	}

}
