package bridge.service;

import java.util.ArrayList;
import java.util.List;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;

public class BridgeGameService {
	private final BridgeMaker bridgeMaker;

	public BridgeGameService() {
		this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
	}

	public List<String> initBridge(int size) {
		validSize(size);
		return bridgeMaker.makeBridge(size);
	}

	public List<List<String>> initGameMap() {
		List<List<String>> moveResult = new ArrayList<>();
		moveResult.add(new ArrayList<>());
		moveResult.add(new ArrayList<>());
		return moveResult;
	}

	public void moveBridge(String moving, BridgeGame bridgeGame, List<List<String>> moveResult) {
		validMoving(moving);
		bridgeGame.move(moving, moveResult);
	}

	private void validSize(int size) {
		if (size < 3 || size > 20) {
			throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
		}
	}

	private void validMoving(String moving) {
		if (!moving.equals("U") && !moving.equals("D")) {
			throw new IllegalArgumentException("[ERROR] 이동 커맨드는 U 또는 D 입니다.");
		}
	}

	public boolean retryOrEnd(String command) {
		validCommand(command);
		return command.equals("R");
	}

	private void validCommand(String command) {
		if (!command.equals("Q") && !command.equals("R")) {
			throw new IllegalArgumentException("[ERROR] 재시작, 종료 커맨드는 R 또는 Q 입니다.");
		}
	}
}
