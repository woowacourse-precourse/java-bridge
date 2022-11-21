package bridge;

import bridge.controller.GameState;
import bridge.vo.Bridge;
import bridge.vo.UserPlayer;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
	private final UserPlayer userPlayer;
	private final Bridge bridge;
	private int stage;

	public BridgeGame(UserPlayer userPlayer, Bridge bridge) {
		this.userPlayer = userPlayer;
		this.bridge = bridge;
		this.stage = 0;
	}

	public boolean isSuccessfulMove(String move) {        // 입력받기
		userPlayer.setMovingDirection(move);
		boolean state = userPlayer.isCrossableStep(bridge, stage);
		if (state) {
			stage += 1;
		}
		return state;
	}

	/**
	 * 사용자가 칸을 이동할 때 사용하는 메서드
	 * <p>
	 * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public GameState move(String move) {
		if (stage == bridge.getBridgeSize()) {
			return GameState.END;
		}
		if (isSuccessfulMove(move)) {
			return GameState.CONTINUATION;
		}
		return GameState.SELECT_GAME_COMMAND;
	}

	public void selectGameContinue(String decision) {    // selectGameContinue호출하는데서 Input입력으로 주기

	}

	/**
	 * 사용자가 게임을 다시 시도할 때 사용하는 메서드
	 * <p>
	 * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void retry() {    // GameState.retry일때
		//	사용자 list초기화
		// 총 시도횟수 업데이트
		// GameState에서 맨트 출력하기
		userPlayer.initUserPlayInformation();
	}

	public void draw() {
		//	사용자리스트 정보,마지막 정보의 갈수있나 유무boolean값을 매개변수로
		// Output에서 그리기
	}

	public int getStage() {
		return stage;
	}
}
