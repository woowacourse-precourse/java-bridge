package bridge.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
	private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
	private static final String OPEN_BRACKET = "[ ";
	private static final String CLOSE_BRACKET = " ]";
	private static final String RESULT = "최종 게임 결과";
	private static final String WIN = "게임 성공 여부: 성공";
	private static final String LOSE = "게임 성공 여부: 실패";
	private static final String TOTAL_TRY = "총 시도한 횟수: ";

	public static void printMap(List<String> state) {
		List<String> upsideState = new ArrayList<>(List.of(state.get(0).split("")));
		List<String> downsideState = new ArrayList<>(List.of(state.get(1).split("")));
		System.out.println(OPEN_BRACKET + toString(upsideState) + CLOSE_BRACKET);
		System.out.println(OPEN_BRACKET + toString(downsideState) + CLOSE_BRACKET);
	}

	public static String toString(List<String> list) {
		StringBuffer line = new StringBuffer();
		for (int i = 3; i < list.size(); i++) {
			line.append(list.get(i));
		}
		return line.toString();
	}

	public static void printResultLose(List<String> state, int tryCount) {
		System.out.println(RESULT);
		printMap(state);
		System.out.println();
		System.out.println(LOSE);
		System.out.println(TOTAL_TRY + tryCount);
	}

	public static void printResultWin(List<String> state, int tryCount) {
		System.out.println(RESULT);
		printMap(state);
		System.out.println();
		System.out.println(WIN);
		System.out.println(TOTAL_TRY + tryCount);
	}

	public static void printStartMessage() {
		System.out.println(START_MESSAGE);
	}
}
