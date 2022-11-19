package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	private static final String SUCCESS = "성공";
	private static final String FAIL = "실패";
	private static final String IS_SUCCESS = "게임 성공 여부: ";
	private static final String MAP_START = "[ ";
	private static final String MAP_END = "]";
	private static final String MAP_BETWEEN = "| ";
	private static final int UP = 1;
	private static final int DOWN = 0;

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(List<List<String>> result) {
		System.out.println(getMap(result, UP));
		System.out.println(getMap(result, DOWN));
	}

	private static String getMap(List<List<String>> result, int upOrDown) {
		String map = "";
		map = map + MAP_START;
		map = map + getMapInfo(result, upOrDown);
		map = map + MAP_END;
		return map;
	}

	private static String getMapInfo(List<List<String>> result, int upOrDown) {
		String map = "";
		for (int i = 0; i < result.size(); i++) {
			map = map + getOXorBlank(result, i, upOrDown) + " ";
			if (result.size() - i != 1) {
				map += MAP_BETWEEN;
			}
		}
		return map;
	}

	private static String getOXorBlank(List<List<String>> result, int i, int upOrDown) {
		if ((result.get(i).get(0).equals("U") && upOrDown == UP) || (result.get(i).get(0).equals("D")
			&& upOrDown == DOWN)) {
			return result.get(i).get(1);
		}
		return " ";
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(List<List<String>> result, int repeat) {
		System.out.println("최종 게임 결과");
		printMap(result);
		printGameSuccessOrFail(result);
		System.out.println("총 시도한 횟수: " + repeat);
	}

	private static void printGameSuccessOrFail(List<List<String>> result) {
		if (isSuccess(result)) {
			System.out.println(IS_SUCCESS + SUCCESS);
			return;
		}
		System.out.println(IS_SUCCESS + FAIL);
	}

	private static boolean isSuccess(List<List<String>> result) {
		return result.get(result.size() - 1).get(1).equals("O");
	}
}
