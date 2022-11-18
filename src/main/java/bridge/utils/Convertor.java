package bridge.utils;

import bridge.domain.dto.MovingResult;
import java.util.ArrayList;
import java.util.List;

public class Convertor {
	private final String NOTHING = "   ";
	private final String RIGHT = " O ";
	private final String WRONG = " X ";
	private static final String SEPARATOR = "|";
	private static final String OPENING_BRACKET = "[";
	private static final String CLOSING_BRACKET = "]";
	private final String SUCCESS = "성공";
	private final String FAIL = "실패";

	public String isSuccess(boolean isSuccess) {
		if (isSuccess) {
			return SUCCESS;
		}
		return FAIL;
	}

	public String joinSplitBridgeMap(String bridgeSplitDirection, List<MovingResult> bridgeMap) {
		StringBuilder convertedBridgeMap = new StringBuilder();
		List<String> splitBridgeMap = splitBridgeMap(bridgeSplitDirection, bridgeMap);
		String joinedSplitBridgeMap = String.join(SEPARATOR, splitBridgeMap);
		convertedBridgeMap.append(OPENING_BRACKET);
		convertedBridgeMap.append(joinedSplitBridgeMap);
		convertedBridgeMap.append(CLOSING_BRACKET);
		return convertedBridgeMap.toString();
	}

	private List<String> splitBridgeMap(String bridgeSplitDirection, List<MovingResult> bridgeMap) {
		List<String> splitBridgeMap = new ArrayList<>();
		bridgeMap.stream()
			.forEach(movingResult -> inputBridgeMap(splitBridgeMap, movingResult, bridgeSplitDirection));
		return splitBridgeMap;
	}

	private void inputBridgeMap(List<String> splitBridgeMap, MovingResult movingResult,
								String bridgeSplitDirection) {
		String bridgeBoxDirection = movingResult.getDirection();
		if (bridgeBoxDirection.equals(bridgeSplitDirection)) {
			whetherRightOrWrong(splitBridgeMap, movingResult);
		}
		if (!bridgeBoxDirection.equals(bridgeSplitDirection)) {
			splitBridgeMap.add(NOTHING);
		}
	}

	private void whetherRightOrWrong(List<String> splitBridgeMap, MovingResult movingResult) {
		if (movingResult.getAnswer()) {
			splitBridgeMap.add(RIGHT);
		}
		if (!movingResult.getAnswer()) {
			splitBridgeMap.add(WRONG);
		}
	}
}
