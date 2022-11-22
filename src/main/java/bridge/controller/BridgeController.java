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
		this.bridgeResult = new BridgeResult();
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
			boolean isRightMove = bridgeGame.move(bridges, askMove(), index);
			map = outputView.printMap(bridges, moves);
			index = retry(isRightMove, index);
		}
		updateResult(bridges,index, map);
	}
	public int retry(boolean isRightmove, int index) {
		if (!isRightmove) {
			index = askRetry();
			bridgeResult.addCountOfAttemps(index);
		}
		return index;
	}

	public void updateResult(List<String> bridges, int moveIndex, String map) {
		if (moveIndex == bridges.size()) {
			bridgeResult.gameSuccess();
		}
		bridgeResult.updateMap(map);
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
