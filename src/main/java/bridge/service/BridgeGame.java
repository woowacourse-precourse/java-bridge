package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.GameRecord;
import bridge.domain.GameSituation;
import bridge.domain.Player;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private Player player;
	private final Bridge bridge;
	private final GameRecord gameRecord;

	public BridgeGame(List<String> bridgeInput) {
		this.player = new Player();
		this.bridge = new Bridge(bridgeInput);
		this.gameRecord = new GameRecord();
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void move(String moving) {
		int currentLocation = player.getCurrentLocation();
		if (bridge.canWalk(currentLocation, moving)) {
			player.move();
			gameRecord.recordSuccess(moving);
			return;
		}
		player.die();
		gameRecord.recordFail(moving);
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry() {
		player = new Player();
		gameRecord.retry();
	}

	Player getPlayer() {
		return player;
	}

	Bridge getBridge() {
		return bridge;
	}

	public GameRecord getGameRecord() {
		return gameRecord;
	}

	public GameSituation checkSituation() {
		if (player.isDead()) {
			return GameSituation.FAIL;
		}
		if (player.getCurrentLocation() == bridge.getLength()) {
			return GameSituation.SUCCESS;
		}
		return GameSituation.ON_GOING;
	}
}
