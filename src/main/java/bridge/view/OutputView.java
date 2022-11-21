package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	public static String START_GAME_PHRASE = "다리 건너기 게임을 시작합니다.";
	public static String USER_FINAL_RESULT_PHRASE = "최종 게임 결과";
	public static String USER_FINAL_RESULT = "게임 성공 여부: ";
	public static String USER_TRY_COUNT_PHRASE = "총 시도한 횟수: ";

	public void printGameStart() {
		System.out.println(START_GAME_PHRASE);
	}

	public void printFinalResultPhrase() {
		System.out.println(USER_FINAL_RESULT_PHRASE);
	}

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(String userBridgeStatus) {
		System.out.println(userBridgeStatus);
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(String result, Integer count) {
		System.out.println(USER_FINAL_RESULT + result);
		System.out.println(
			USER_TRY_COUNT_PHRASE + String.format("%d", count));
	}

	public void printError(String errorMessage) {
		System.out.println(errorMessage);
	}
}
