package bridge.view;

import bridge.BridgeMap;
import java.util.List;

public class OutputView {
	private final String RESULTS_OF_FINAL_GAME = "최종 게임 결과";
	private final String WHETHER_GAME_SUCCESS = "게임 성공 여부: ";
	private final String TOTAL_NUMBER_OF_ATTEMPTS = "총 시도한 횟수: ";
	private final int SPLIT_DIRECTION_UP = 0;
	private final int SPLIT_DIRECTION_DOWN = 1;

	public void printMap(BridgeMap bridgeMap) {
		List<String> splitBridgeMap = bridgeMap.getSplitMap();
		String upBridgeMap = splitBridgeMap.get(SPLIT_DIRECTION_UP);
		String downBridgeMap = splitBridgeMap.get(SPLIT_DIRECTION_DOWN);
		System.out.println(upBridgeMap);
		System.out.println(downBridgeMap);
		System.out.println();
	}
	
	public void printResult(int tryNumber, BridgeMap bridgeMap, String gameSuccessOrFail) {
		System.out.println(RESULTS_OF_FINAL_GAME);
		printMap(bridgeMap);
		System.out.println(WHETHER_GAME_SUCCESS + gameSuccessOrFail);
		System.out.println(TOTAL_NUMBER_OF_ATTEMPTS + tryNumber);
	}
}
