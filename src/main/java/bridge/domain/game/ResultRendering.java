package bridge.domain.game;

import bridge.domain.map.BridgeMap;

import java.util.HashMap;
import java.util.stream.Collectors;

public class ResultRendering {

	private static final String RESULT_PRESENTATION = "최종 게임 결과";
	private static final String RESULT_FAIL_OR_SUCCESS = "게임 성공 여부: %s";
	private static final String RESULT_TRIAL = "총 시도한 횟수: %d";
	private static final String ENTER = "\n";
	private static final String PARAGRAPH = "\n\n";

	private static String BridgeRendered;

	private ResultRendering(BridgeMap bridgeMap) {
		BridgeRendered = renderTotalBridge(bridgeMap);
	}

	public static ResultRendering generatedBy(BridgeMap bridgeMap) {
		return new ResultRendering(bridgeMap);
	}

	public static String renderFinalResult(HashMap<String, Integer> gameResult) {
		return RESULT_PRESENTATION
				+ ENTER + BridgeRendered
				+ PARAGRAPH + String.format(RESULT_FAIL_OR_SUCCESS, gameResult.keySet().toArray()[0])
				+ ENTER + String.format(RESULT_TRIAL, (Integer) gameResult.values().toArray()[0]);
	}

	private String renderUpperBridge(BridgeMap bridgeMap) {
		return bridgeMap.getUpperBridgeDescription().stream()
				.map(String::toString).collect(Collectors.joining());
	}

	private String renderUnderBridge(BridgeMap bridgeMap) {
		return String.join("", bridgeMap.getUnderBridgeDescription());
	}

	private String renderTotalBridge(BridgeMap bridgeMap) {
		return renderUpperBridge(bridgeMap) + ENTER + renderUnderBridge(bridgeMap);
	}

	public String getBridgeRendered() {
		return BridgeRendered;
	}
}
