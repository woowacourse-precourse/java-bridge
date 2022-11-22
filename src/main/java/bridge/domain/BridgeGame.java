package bridge.domain;

import bridge.controller.GameState;
import bridge.vo.Bridge;
import bridge.vo.UserPlayer;

public class BridgeGame {
	private final UserPlayer userPlayer;
	private final Bridge bridge;
	private int stage;

	public BridgeGame(UserPlayer userPlayer, Bridge bridge) {
		this.userPlayer = userPlayer;
		this.bridge = bridge;
		this.stage = 0;
	}

	public GameState move(String move) {
		if (isSuccessfulMove(move)) {
			if (isEndOfBridge()) {
				return GameState.SUCCESS_END;
			}
			return GameState.CONTINUATION;
		}
		return GameState.SELECT_GAME_COMMAND;
	}

	public boolean isSuccessfulMove(String move) {
		userPlayer.setMovingDirection(move);
		boolean state = userPlayer.isCrossStep(bridge, stage);
		if (state) {
			stage += 1;
		}
		return state;
	}

	public boolean isEndOfBridge() {
		return stage == bridge.getBridgeSize();
	}

	public GameState selectGameContinue(String decision) {
		if (decision.equals(GameState.RETRY.getCode())) {
			retry();
			return GameState.CONTINUATION;
		}
		return GameState.FAIL_END;
	}

	public void retry() {
		userPlayer.initUserPlayInformation();
		stage = 0;
	}

	// public void draw(GameState result) {
	// 	OutputView.printMap(result, userPlayer.getMoveRecord());
	// 	OutputView.printResult(result, userPlayer.getTotalAttempt());
	// }
}
