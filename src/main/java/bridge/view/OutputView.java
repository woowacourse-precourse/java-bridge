package bridge.view;

import java.util.List;

import bridge.domain.BridgeGame;

public class OutputView {
	private static final String PRINT_MAP_FIRST_LETTER = "[ ";
	private static final String PRINT_MAP_LAST_LETTER = " ]";
	private static final String PRINT_MAP_DELIMITER = " | ";

	public void printMap(List<List<String>> result) {
		String upBridge = createBridgeMap(result.get(0));
		String downBridge = createBridgeMap(result.get(1));
		System.out.println(upBridge);
		System.out.println(downBridge);
		System.out.println();
	}

	private String createBridgeMap(List<String> map) {
		StringBuilder stringBuilder = new StringBuilder().append(PRINT_MAP_FIRST_LETTER);
		for (String point : map) {
			stringBuilder.append(point).append(PRINT_MAP_DELIMITER);
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		return stringBuilder.append(PRINT_MAP_LAST_LETTER).toString();
	}

	public void printResult(List<List<String>> result, BridgeGame bridgeGame) {
		if (result.get(0).size() == bridgeGame.getBridgeSize()) {
			printClearMap(result, bridgeGame.getRepeatCount());
		}
		if (result.get(0).size() != bridgeGame.getBridgeSize()) {
			printFailedMap(result, bridgeGame.getRepeatCount());
		}
	}

	private void printClearMap(List<List<String>> result, int count) {
		printResultIntro(result);
		System.out.println("게임 성공 여부: 성공");
		System.out.printf("총 시도한 횟수: %d%n", count);
	}

	private void printFailedMap(List<List<String>> result, int count) {
		printResultIntro(result);
		System.out.println("게임 성공 여부: 실패");
		System.out.printf("총 시도한 횟수: %d%n", count);
	}

	private void printResultIntro(List<List<String>> result) {
		System.out.println("최종 게임 결과");
		printMap(result);
	}
}
