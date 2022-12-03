package bridge.utils;

import bridge.MovingResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convertor {
	private final String BLANK = " ";
	private final String RIGHT = "O";
	private final String WRONG = "X";
	private final String SEPARATOR = " | ";
	private final String OPENING_BRACKET = "[ ";
	private final String CLOSING_BRACKET = " ]";
	private final String SUCCESS = "성공";
	private final String FAIL = "실패";
	private static final String UP_DIRECTION = "U";
	private static final String DOWN_DIRECTION = "D";
	private static final int RANDOM_LOWER_INCLUSIVE = 0;

	public static String convertMovingDirection(int number) {
		if (number == RANDOM_LOWER_INCLUSIVE) {
			return DOWN_DIRECTION;
		}
		return UP_DIRECTION;
	}

	public String convertSuccessOrFail(boolean isSuccess) {
		if (isSuccess) {
			return SUCCESS;
		}
		return FAIL;
	}

	public List<String> convertSplitBridgeMap(List<MovingResult> bridgeMap) {
		List<String> upBridgeMap = new ArrayList<>();
		List<String> downBridgeMap = new ArrayList<>();
		bridgeMap.stream()
			.forEach(movingResult -> splitBridgeMap(movingResult, upBridgeMap, downBridgeMap));
		return new ArrayList<>(Arrays.asList(toString(upBridgeMap), toString(downBridgeMap)));
	}

	private void splitBridgeMap(MovingResult movingResult, List<String> upBridgeMap, List<String> downBridgeMap) {
		if (movingResult.isMovingDirectionUp()) {
			addSplitBridgeMap(movingResult, upBridgeMap);
			downBridgeMap.add(BLANK);
		}
		if (movingResult.isMovingDirectionDown()) {
			addSplitBridgeMap(movingResult, downBridgeMap);
			upBridgeMap.add(BLANK);
		}
	}

	private void addSplitBridgeMap(MovingResult movingResult, List<String> splitBridgeMap) {
		if (movingResult.isMovingSuccess()) {
			splitBridgeMap.add(RIGHT);
		}
		if (!movingResult.isMovingSuccess()) {
			splitBridgeMap.add(WRONG);
		}
	}

	private String toString(List<String> splitBridgeMap) {
		StringBuilder convertedBridgeMap = new StringBuilder();
		convertedBridgeMap.append(OPENING_BRACKET);
		convertedBridgeMap.append(String.join(SEPARATOR, splitBridgeMap));
		convertedBridgeMap.append(CLOSING_BRACKET);
		return convertedBridgeMap.toString();
	}
}
