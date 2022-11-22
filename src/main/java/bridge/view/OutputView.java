package bridge.view;

import bridge.BridgeMap;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	private final String RESULTS_OF_FINAL_GAME = "최종 게임 결과";
	private final String WHETHER_GAME_SUCCESS = "게임 성공 여부: ";
	private final String TOTAL_NUMBER_OF_ATTEMPTS = "총 시도한 횟수: ";
	private final int SPLIT_DIRECTION_UP = 0;
	private final int SPLIT_DIRECTION_DOWN = 1;

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(BridgeMap bridgeMap) {
		List<String> splitBridgeMap = bridgeMap.getSplitMap();
		String upBridgeMap = splitBridgeMap.get(SPLIT_DIRECTION_UP);
		String downBridgeMap = splitBridgeMap.get(SPLIT_DIRECTION_DOWN);
		System.out.println(upBridgeMap);
		System.out.println(downBridgeMap);
		System.out.println();
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(int tryNumber, BridgeMap bridgeMap, String gameSuccessOrFail) {
		System.out.println(RESULTS_OF_FINAL_GAME);
		printMap(bridgeMap);
		System.out.println(WHETHER_GAME_SUCCESS + gameSuccessOrFail);
		System.out.println(TOTAL_NUMBER_OF_ATTEMPTS + tryNumber);
	}
}
