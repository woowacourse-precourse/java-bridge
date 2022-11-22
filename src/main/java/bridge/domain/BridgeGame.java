package bridge.domain;

import bridge.domain.dto.GameCommand;
import bridge.domain.dto.Moving;
import bridge.utils.Controller.InputController;
import bridge.utils.Controller.ViewController;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private final String RETRY = "R";
	private ViewController viewController = new ViewController();
	private InputController inputController = new InputController();
	private Bridge bridge;

	public BridgeGame(Bridge bridge) {
		this.bridge = bridge;
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean move() {
		Moving moving = inputController.getMoving();
		User user = new User(moving.getMoving());
		return user.checkMoving(bridge);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry() {
		GameCommand gameCommand = inputController.getGameCommand();
		String command = gameCommand.getCommand();
		if (command.equals(RETRY)) {
			return true;
		}
		return false;
	}

	public boolean keepMove() {
		return bridge.isCrossBridge();
	}

	public BridgeMap getBridgeMap() {
		return bridge.getBridgeMap();
	}

	public void resetGame() {
		bridge.resetGame();
	}
}
