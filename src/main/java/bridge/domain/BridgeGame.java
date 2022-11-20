package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.dto.BridgeSize;
import bridge.domain.dto.GameCommand;
import bridge.domain.dto.Moving;
import bridge.utils.Input;
import bridge.view.View;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private final String RETRY = "R";
	private final String QUIT = "Q";
	private final boolean GAME_SUCCESS = true;
	private final boolean GAME_FAIL = false;
	private int tryNumber = 0;

	public void start() {
		try {
			Bridge bridge = createBridge();
			play(bridge);
		} catch (IllegalArgumentException error) {
			System.out.println(error);
			return;
		}
	}

	private Bridge createBridge() {
		BridgeSize bridgeSize = Input.bridgeSize();
		BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
		List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getSize());
		return new Bridge(bridge);
	}

	private void play(Bridge bridge) {
		tryNumber++;
		BridgeMap bridgeMap = new BridgeMap();
		boolean gameResult = isGameSuccess(bridge, bridgeMap);
		gameOverOrRetry(gameResult, bridge, bridgeMap);
	}

	private boolean isGameSuccess(Bridge bridge, BridgeMap bridgeMap) {
		while (!bridge.isMovingEnd()) {
			boolean moveResult = move(bridge, bridgeMap);
			if (!moveResult) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean move(Bridge bridge, BridgeMap bridgeMap) {
		User user = inputMoving();
		MovingResult movingResult = user.selectMoving(bridge);
		bridgeMap.addMovingResult(movingResult);
		printBridgeMap(bridgeMap);
		return movingResult.isMovingSuccess();
	}

	private User inputMoving() {
		Moving moving = Input.moving();
		return new User(moving.getMoving());
	}

	private void printBridgeMap(BridgeMap bridgeMap) {
		View view = new View();
		view.printBridgeMap(bridgeMap);
	}

	private void gameOverOrRetry(boolean gameResult, Bridge bridge, BridgeMap bridgeMap) {
		if (gameResult) {
			gameOver(bridgeMap);
		}
		if (!gameResult) {
			retry(bridge, bridgeMap);
		}
	}

	private void gameOver(BridgeMap bridgeMap) {
		View view = new View();
		view.printGameResult(tryNumber, bridgeMap, GAME_SUCCESS);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry(Bridge bridge, BridgeMap bridgeMap) {
		GameCommand gameCommand = Input.gameCommand();
		String command = gameCommand.getCommand();
		retryGame(command, bridge);
		quitGame(command, bridgeMap);
	}

	private void retryGame(String command, Bridge bridge) {
		if (command.equals(RETRY)) {
			bridge.resetCurrentLocation();
			play(bridge);
		}
	}

	private void quitGame(String command, BridgeMap bridgeMap) {
		if (command.equals(QUIT)) {
			View view = new View();
			view.printGameResult(tryNumber, bridgeMap, GAME_FAIL);
		}
	}
}
