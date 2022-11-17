package bridge.view;

import java.util.stream.IntStream;

import bridge.BridgeGame;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	private static final String BRIDGE_START = "[ ";
	private static final String BRIDGE_END = " ]";
	private static final String VERTICAL_BAR = " | ";
	private static final int INIT_INDEX = 0;

	public static StringBuffer mapResult;

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(int moveCount) {
		String[][] map = BridgeGame.getMap();

		IntStream.range(INIT_INDEX, map.length).forEach(rowIndex -> {
			mapResult = new StringBuffer();
			makeMapResult(rowIndex, moveCount);
			System.out.println(mapResult);
		});
	}

	private static void makeMapResult(int rowIndex, int moveCount) {
		String[][] map = BridgeGame.getMap();

		mapResult.append(BRIDGE_START);
		IntStream.range(INIT_INDEX, moveCount).forEach(colIndex -> {
			appendXOrO(colIndex, map[rowIndex]);
			appendVerticalBar(colIndex, moveCount - 1);
		});
		mapResult.append(BRIDGE_END);
	}

	private static void appendXOrO(int colIndex, String[] map) {
		mapResult.append(map[colIndex]);
	}

	private static void appendVerticalBar(int colIndex, int moveCount) {
		if (colIndex < moveCount) {
			mapResult.append(VERTICAL_BAR);
		}
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(int moveCount, int tryCount) {
		GuideMessageView.GAME_RESULT_GUIDE_MESSAGE.printMessage();
		printMap(moveCount);

		printSuccessGuideMessage();
		printFailGuideMessage();

		GuideMessageView.TRY_COUNT_GUIDE_MESSAGE.printMessage();
		System.out.println(tryCount);
	}

	private static void printFailGuideMessage() {
		if (BridgeGame.isFailCrossBridge()) {
			GuideMessageView.GAME_FAIL_GUIDE_MESSAGE.printMessage();
		}
	}

	private static void printSuccessGuideMessage() {
		if (BridgeGame.isClearCrossBridge()) {
			GuideMessageView.GAME_SUCCESS_GUIDE_MESSAGE.printMessage();
		}
	}

	public static void printExceptionMessage(IllegalArgumentException exception) {
		System.out.println(exception.getMessage());
	}
}
