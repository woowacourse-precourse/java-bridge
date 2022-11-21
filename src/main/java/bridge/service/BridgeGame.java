package bridge.service;

import static bridge.view.InputView.RETRY;

import bridge.domain.Bridge;
import bridge.domain.BridgeResult;
import bridge.domain.BridgeStatus;
import bridge.domain.GameStatus;
import bridge.domain.Player;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private static final int RETRY_NUMBER = 0;
	private final Bridge bridge;
	private final Player player;
	private int bridgeNumber = 0;

	public BridgeGame(List<String> bridge) {
		this.bridge = new Bridge(bridge);
		this.player = new Player();
	}

	public GameStatus isClear() {
		if (bridge.isEnd(bridgeNumber)) {
			return GameStatus.CLEAR;
		}

		return GameStatus.PASS;
	}

	public void checkClear(BridgeResult bridgeResult) {
		if (isClear() == GameStatus.CLEAR) {
			this.player.gameClear(bridgeResult);
		}
	}

	public void end(BridgeResult bridgeResult) {
		this.bridgeNumber = bridge.getSize();
		this.player.gameQuit(bridgeResult);
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public BridgeStatus move(String input) {
		return bridge.isBridgeStatus(input, bridgeNumber++);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public boolean retry(String gameCommand) {
		if (gameCommand.equals(RETRY)) {
			this.bridgeNumber = RETRY_NUMBER;
			this.player.addRetry();

			return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return this.player.toString();
	}
}
