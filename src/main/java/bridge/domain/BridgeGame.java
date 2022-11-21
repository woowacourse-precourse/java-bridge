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
	private View view = new View();
	private Bridge bridge;
	private int tryNumber = 0;

	public void start() {
		try {
			this.bridge = createBridge();
			play();
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

	private void play() {
		tryNumber++;
		BridgeMap bridgeMap = new BridgeMap();
		boolean gameResult = isGameSuccess(bridgeMap);
		gameOverOrRetry(gameResult, bridgeMap);
	}

	private boolean isGameSuccess(BridgeMap bridgeMap) {
		while (!bridge.isMovingEnd()) {
			User user = inputMoving();
			boolean moveResult = move(user, bridge, bridgeMap);
			if (!moveResult) {
				return false;
			}
		}
		return true;
	}

	private User inputMoving() {
		Moving moving = Input.moving();
		return new User(moving.getMoving());
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean move(User user, Bridge bridge, BridgeMap bridgeMap) {
		MovingResult movingResult = user.selectMoving(bridge);
		bridgeMap.addMovingResult(movingResult);
		view.printBridgeMap(bridgeMap);
		return movingResult.isMovingSuccess();
	}

	private void gameOverOrRetry(boolean gameResult, BridgeMap bridgeMap) {
		if (gameResult) {
			gameOver(bridgeMap);
		}
		if (!gameResult) {
			GameCommand gameCommand = Input.gameCommand();
			String command = gameCommand.getCommand();
			retry(command, bridgeMap);
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
	public void retry(String command, BridgeMap bridgeMap) {
		retryGame(command);
		quitGame(command, bridgeMap);
	}

	private void retryGame(String command) {
		if (command.equals(RETRY)) {
			bridge.resetCurrentLocation();
			play();
		}
	}

	private void quitGame(String command, BridgeMap bridgeMap) {
		if (command.equals(QUIT)) {
			view.printGameResult(tryNumber, bridgeMap, GAME_FAIL);
		}
	}
}
