package bridge.view;

import bridge.model.domain.GameResult;
import bridge.model.domain.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
	private static final String STAIRS_MESSAGE = "[%s]%n[%s]%n";
	private static final String END_MESSAGE = "\n최종 게임 결과";
	private static final String RESULT_MESSAGE = "\n게임 성공 여부: %s%n";
	private static final String TOTAL_TRY_NUMBER_MESSAGE = "총 시도한 횟수: %s%n";

	public void printStartMessage() {
		System.out.println(START_MESSAGE);
	}

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(Map map) {
		System.out.printf(STAIRS_MESSAGE, map.getUpstairs(), map.getDownstairs());
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(Map map, GameResult gameResult) {
		System.out.println(END_MESSAGE);

		printMap(map);

		System.out.printf(RESULT_MESSAGE, gameResult.getResult());
		System.out.printf(TOTAL_TRY_NUMBER_MESSAGE, gameResult.getNumberOfAttempts());
	}
}
