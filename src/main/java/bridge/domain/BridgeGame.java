package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.domain.dto.BridgeSize;
import bridge.domain.dto.GameCommand;
import bridge.domain.dto.Moving;
import bridge.domain.dto.MovingResult;
import bridge.utils.Input;
import bridge.view.View;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private final String RETRY = "R";
	private final String QUIT = "Q";
	private final int CURRENT_LOCATION_RESET = 0;
	private final int TRY_NUMBER_RESET = 0;
	private final boolean GAME_SUCCESS = true;
	private final boolean GAME_FAIL = false;
	private int tryNumber = TRY_NUMBER_RESET;

	public void start() {
		Bridge bridge = createBridge();
		play(bridge);
	}

	private Bridge createBridge() {
		BridgeSize bridgeSize = Input.bridgeSize();
		BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
		BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
		List<String> bridge = bridgeMaker.makeBridge(bridgeSize.getSize());
		return new Bridge(bridge, bridgeSize.getSize());
	}

	private void play(Bridge bridge) {
		addTryNumber();
		BridgeMap bridgeMap = new BridgeMap();
		result(bridge, bridgeMap);
	}

	private void addTryNumber() {
		this.tryNumber++;
	}

	private void result(Bridge bridge, BridgeMap bridgeMap) {
		boolean isGameSuccess = playOneGame(bridge, bridgeMap);
		gameSuccess(isGameSuccess, bridgeMap);
		gameFail(isGameSuccess, bridgeMap, bridge);
	}

	private boolean playOneGame(Bridge bridge, BridgeMap bridgeMap) {
		int currentLocation = CURRENT_LOCATION_RESET;
		while (currentLocation < bridge.getSize()) {
			move(bridge, bridgeMap, currentLocation);
			if (!bridgeMap.isMovingSuccess(currentLocation)) {
				return false;
			}
			currentLocation++;
		}
		return true;
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move(Bridge bridge, BridgeMap bridgeMap, int currentLocation) {
		View view = new View();
		Moving moving = Input.moving();
		User user = new User(moving.getMoving());
		MovingResult movingResult = user.selectMoving(currentLocation, bridge);
		bridgeMap.addResult(movingResult);
		view.printBridgeMap(bridgeMap);
	}

	private void gameSuccess(boolean isGameSuccess, BridgeMap bridgeMap) {
		if (isGameSuccess) {
			View view = new View();
			view.printGameResult(tryNumber, bridgeMap, GAME_SUCCESS);
		}
	}

	private void gameFail(boolean isGameSuccess, BridgeMap bridgeMap, Bridge bridge) {
		if (!isGameSuccess) {
			retry(bridge, bridgeMap);
		}
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
