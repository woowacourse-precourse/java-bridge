package bridge.utils;

import bridge.domain.MovingResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convertor {
	private final String BLANK = " ";
	private final String RIGHT = "O";
	private final String WRONG = "X";
	private static final String SEPARATOR = " | ";
	private static final String OPENING_BRACKET = "[ ";
	private static final String CLOSING_BRACKET = " ]";
	private final String SUCCESS = "성공";
	private final String FAIL = "실패";

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
