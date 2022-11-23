package bridge.domain;

import java.util.List;

public class BridgeGameResultCalculator {
	private static final String CANNOT_MOVE = "X";
	private static final String CAN_MOVE = "O";
	private static final String NONE = " ";

	private static final BridgeGameResult bridgeGameResult = new BridgeGameResult();

	public static BridgeGameResult getMovingResults(final List<String> bridge, final String moving) {
		saveMovingRecord(isMovable(bridge, moving), moving);
		changeGameStatusToSuccessIfSuccess(bridge.size());
		return bridgeGameResult;
	}

	private static boolean isMovable(final List<String> bridge, final String moving) {
		int moveCount = BridgeGameResult.getMoveCount();
		boolean movable = bridge.get(moveCount).equals(moving);

		changeGameStatusToFailIfNotMovable(movable);

		return movable;
	}

	private static void saveMovingRecord(final boolean isCanMove, final String moving) {
		if (isUpMoving(moving)) {
			addUpMoving(isCanMove);
			return;
		}
		addDownMoving(isCanMove);
	}

	private static void changeGameStatusToSuccessIfSuccess(final int bridgeSize) {
		if (isGameSuccess(bridgeSize)) {
			BridgeGameResult.changeGameStatusToSuccess();
		}
	}

	private static boolean isGameSuccess(final int bridgeSize) {
		return BridgeGameResult.getSuccessfulMoveCount() == bridgeSize;
	}

	private static void changeGameStatusToFailIfNotMovable(final boolean movable) {
		if (!movable) {
			BridgeGameResult.changeGameStatusToFail();
		}
	}

	private static boolean isUpMoving(final String moving) {
		return moving.equals("U");
	}

	private static void addUpMoving(final boolean isCanMove) {
		if (isCanMove) {
			bridgeGameResult.addUpMoving(CAN_MOVE);
			bridgeGameResult.addDownMoving(NONE);
			BridgeGameResult.increaseMoveSuccessCount();
			return;
		}
		bridgeGameResult.addUpMoving(CANNOT_MOVE);
		bridgeGameResult.addDownMoving(NONE);
	}

	private static void addDownMoving(final boolean isCanMove) {
		if (isCanMove) {
			bridgeGameResult.addUpMoving(NONE);
			bridgeGameResult.addDownMoving(CAN_MOVE);
			BridgeGameResult.increaseMoveSuccessCount();
			return;
		}
		bridgeGameResult.addUpMoving(NONE);
		bridgeGameResult.addDownMoving(CANNOT_MOVE);
	}
}
