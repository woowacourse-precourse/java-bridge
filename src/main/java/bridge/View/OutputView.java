package bridge.View;

import bridge.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(String[][] map, int moveCount) {
		for (int rowIndex = 0; rowIndex < map.length; rowIndex++) {
			StringBuffer mapResult = new StringBuffer();

			makeMapResult(map, rowIndex, mapResult, moveCount);

			System.out.println(mapResult);
		}
	}

	private static void makeMapResult(String[][] map, int rowIndex, StringBuffer mapResult, int moveCount) {
		mapResult.append("[");
		for (int colIndex = 0; colIndex < moveCount; colIndex++) {
			appendXOrO(mapResult, colIndex, map[rowIndex]);
			appendVerticalBar(map, rowIndex, mapResult, colIndex, moveCount);
		}
		mapResult.append("]");
	}

	private static void appendXOrO(StringBuffer mapResult, int colIndex, String[] map) {
		mapResult.append(map[colIndex]);
	}

	private static void appendVerticalBar(String[][] map, int rowIndex, StringBuffer mapResult, int colIndex,
		int moveCount) {
		if (colIndex < moveCount - 1) {
			mapResult.append("|");
		}
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(String[][] map, int moveCount, int tryCount) {
		GuideMessageView.GAME_RESULT_GUIDE_MESSAGE.printMessage();
		printMap(map, moveCount);

		if (BridgeGame.isClearCrossBridge()) {
			GuideMessageView.GAME_SUCCESS_GUIDE_MESSAGE.printMessage();

		}

		if (BridgeGame.isFailCrossBridge()) {
			GuideMessageView.GAME_FAIL_GUIDE_MESSAGE.printMessage();
		}

		GuideMessageView.TRY_COUNT_GUIDE_MESSAGE.printMessage();
		System.out.println(tryCount);
	}
}
