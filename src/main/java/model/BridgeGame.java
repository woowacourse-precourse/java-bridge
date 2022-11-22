package model;

import static model.BridgeGameConstants.*;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

	private final List<String> bridge;
	private int currentPos;
	private int gameRoundCount;

	public BridgeGame(final List<String> bridge) {
		this.bridge = bridge;
		this.currentPos = START_POSITION;
		this.gameRoundCount = FIRST_ROUND;
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public int move(String moving) {
		if (canGoNextStep(moving)) {
			currentPos += ONE_STEP_FORWARD;
			if (currentPos == bridge.size() - USELESS_SPACE_OF_BRIDGE) {
				return MOVING_SUCCESS_GAME_END;
			}
			return MOVING_SUCCESS;
		}
		return MOVING_FAIL_WRONG_MOVING;
	}

	private boolean canGoNextStep(String moving) {
		int nextPosition = currentPos + ONE_STEP_FORWARD;
		if (moving.equals(MOVING_DOWN) && bridge.get(nextPosition).equals(MOVING_UP)) {
			return false;
		}
		if (moving.equals(MOVING_UP) && bridge.get(nextPosition).equals(MOVING_DOWN)) {
			return false;
		}
		return true;
	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry() {
		this.currentPos = START_POSITION;
		gameRoundCount += ROUND_INCREASE;
	}

	public int getGameRoundCount() {
		return gameRoundCount;
	}
}