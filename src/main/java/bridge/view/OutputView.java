package bridge.view;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
	private static final String OPEN_BRACKET = "[ ";
	private static final String CLOSE_BRACKET = " ]";
	private static final String RESULT = "최종 게임 결과";
	private static final String WIN = "게임 성공 여부: 성공";
	private static final String LOSE = "게임 성공 여부: 실패";
	private static final String TOTAL_TRY = "총 시도한 횟수: ";
	private int tries = 0;

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public static void printMap(String upsideBridge) {
		List<String> upsideCase = new ArrayList<>(List.of(upsideBridge.split("")));
		int i = 0;
		while (i < 3) {
			upsideCase.remove(0);
			i++;
		}
		System.out.println(OPEN_BRACKET + toString(upsideCase) + CLOSE_BRACKET);
	}

	public static String toString(List<String> list) {
		StringBuffer line = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			line.append(list.get(i));
		}
		return line.toString();
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public static void printResult() {
		System.out.println(RESULT);
	}

	public static void printStartMessage() {
		System.out.println(START_MESSAGE);
	}

	public void resetTries() {
		this.tries = 0;
	}
}
