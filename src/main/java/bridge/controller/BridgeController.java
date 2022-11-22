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
		int moveIndex = 0;
		String map = "";
		while (moveIndex < bridges.size()) {
			String moveCommand = askMove();
			boolean isRightMove = bridgeGame.move(bridges, moveCommand, moveIndex);
			map = outputView.printMap(bridges, moves);
			moveIndex++;
			if (!isRightMove) {
				moveIndex = askRetry();
				bridgeResult.addCountOfAttemps(moveIndex);
			}
		}
		updateResult(bridges, moveIndex, map);
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
			outputView.printRetry();
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
