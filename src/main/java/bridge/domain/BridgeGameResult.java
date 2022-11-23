package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameResult {
	private static final List<String> upGameResult = new ArrayList<>();
	private static final List<String> downGameResult = new ArrayList<>();
	private static int moveCount = 0;
	private static int successfulMoveCount = 0;

	private static BridgeGameStatus bridgeGameStatus = BridgeGameStatus.GAME_PROCESSING;

	public static int getMoveCount() {
		return moveCount;
	}

	public static void changeGameStatusToSuccess() {
		bridgeGameStatus = BridgeGameStatus.GAME_SUCCESS;
	}

	public static int getSuccessfulMoveCount() {
		return successfulMoveCount;
	}

	public static void changeGameStatusToFail() {
		bridgeGameStatus = BridgeGameStatus.GAME_FAILED;
	}

	public void addUpMoving(final String result) {
		upGameResult.add(result);
	}

	public void addDownMoving(final String result) {
		downGameResult.add(result);
	}

	public static void increaseMoveCount() {
		moveCount++;
	}

	public static void increaseMoveSuccessCount() {
		successfulMoveCount++;
	}

	public static String getUpGameResultByIndex(final int index) {
		return upGameResult.get(index);
	}

	public static String getDownGameResultByIndex(final int index) {
		return downGameResult.get(index);
	}

	public static boolean isGameProcessing() {
		return bridgeGameStatus == BridgeGameStatus.GAME_PROCESSING;
	}

	public static boolean isGameFailed() {
		return bridgeGameStatus == BridgeGameStatus.GAME_FAILED;
	}

	public static boolean isGameEnd() {
		return bridgeGameStatus == BridgeGameStatus.GAME_SUCCESS || bridgeGameStatus == BridgeGameStatus.GAME_FAILED;
	}

	public static void resetResult() {
		upGameResult.clear();
		downGameResult.clear();
		moveCount = 0;
		successfulMoveCount = 0;
	}

	public static void changeGameStatusToProcessing() {
		bridgeGameStatus = BridgeGameStatus.GAME_PROCESSING;
	}

	public static String getFinalGameStatus() {
		return bridgeGameStatus.getStatus();
	}
}
