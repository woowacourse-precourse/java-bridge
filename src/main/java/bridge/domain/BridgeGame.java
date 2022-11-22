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
	private final boolean GAME_SUCCESS = true;
	private final boolean GAME_FAIL = false;
	private View view = new View();
	private Input input = new Input();
	private Bridge bridge;
	private int tryNumber = 0;

	public void start() {
		try {
			bridge = createBridge();
			play();
		} catch (IllegalArgumentException error) {
			System.out.println(error.getMessage());
			return;
		}
	}

	private Bridge createBridge() {
		BridgeSize bridgeSize = input.bridgeSize();
		BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
		List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getSize());
		return new Bridge(bridge);
	}

	private void play() {
		tryNumber++;
		BridgeMap bridgeMap = new BridgeMap();
		boolean gameResult = isGameSuccess(bridgeMap);
		gameOverOrRetry(gameResult, bridgeMap);
	}

	private boolean isGameSuccess(BridgeMap bridgeMap) {
		while (!bridge.isCrossBridge()) {
			Moving moving = input.moving();
			User user = new User(moving.getMoving());
			boolean moveResult = move(user, bridge, bridgeMap);
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
	public boolean move(User user, Bridge bridge, BridgeMap bridgeMap) {
		MovingResult movingResult = user.checkMoving(bridge);
		bridgeMap.addMovingResult(movingResult);
		view.printBridgeMap(bridgeMap);
		return movingResult.isMovingSuccess();
	}

	private void gameOverOrRetry(boolean gameResult, BridgeMap bridgeMap) {
		if (gameResult) {
			gameOver(bridgeMap);
		}
		if (!gameResult) {
			boolean isRetry = retry();
			gameRestartOrQuit(isRetry, bridgeMap);
		}
	}

	private void gameOver(BridgeMap bridgeMap) {
		view.printGameResult(tryNumber, bridgeMap, GAME_SUCCESS);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry() {
		GameCommand gameCommand = input.gameCommand();
		String command = gameCommand.getCommand();
		if (command.equals(RETRY)) {
			return true;
		}
		return false;
	}

	private void gameRestartOrQuit(boolean isRetry, BridgeMap bridgeMap) {
		if (isRetry) {
			retryGame();
		}
		if (!isRetry) {
			quitGame(bridgeMap);
		}
	}

	private void retryGame() {
		bridge.resetCurrentLocation();
		play();
	}

	private void quitGame(BridgeMap bridgeMap) {
		view.printGameResult(tryNumber, bridgeMap, GAME_FAIL);
	}
}
