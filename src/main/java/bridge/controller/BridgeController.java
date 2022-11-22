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


	public void run() {
		outputView.printStartGame();
		List<String> bridges = makeBridge();
		askMove(bridges);

	}

	public List<String> makeBridge() {
		int size = askBridgeSize();
		List<String> bridges = bridgeGame.makeBridge(size);
		return bridges;

	}

	public int askBridgeSize() {
		while (true) {
			try {
				outputView.printSizeSelect();
				return inputView.readBridgeSize();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void askMove(List<String> bridges) {
		int size = bridges.size();
		int index = 0;

		while (index < size) {
			String move = moving();
			moves.add(move);
			boolean canMove = bridgeGame.move(bridges, moves,
					index);// 이동을 했을때 boolean 값을 받아서 이동할 칸 입력 or retry할지 선택
			map = outputView.printMap(bridges, moves);
			index++;
			if (!canMove) {//실패하면 false 성공하면 true
				index = askRetry();
				numberOfAttempts++;
			}
		}
		if (index == size) {
			successGame = "성공";
			numberOfAttempts++;
		}
		outputView.printResult(numberOfAttempts, successGame, map);
	}

	public String moving() {
		try {
			outputView.printMoveSelect();
			return inputView.readMoving();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return moving();
		}
	}

	public int askRetry() {
		try {
			outputView.printRetry();
			String command = inputView.readGameCommand();
			moves = new ArrayList<>();
			return bridgeGame.retry(command);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return askRetry();
		}
	}

}
