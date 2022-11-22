package bridge.view;

public class OutputView {

	public static final String START_GAME_PHRASE = "다리 건너기 게임을 시작합니다.";
	public static final String USER_FINAL_RESULT_PHRASE = "최종 게임 결과";
	public static final String USER_FINAL_RESULT = "게임 성공 여부: ";
	public static final String USER_TRY_COUNT_PHRASE = "총 시도한 횟수: ";

	public void printGameStart() {
		System.out.println(START_GAME_PHRASE);
	}

	public void printFinalResultPhrase() {
		System.out.println(USER_FINAL_RESULT_PHRASE);
	}

	public void printMap(String userBridgeStatus) {
		System.out.println(userBridgeStatus);
	}

	public void printResult(String result, Integer count) {
		System.out.println(USER_FINAL_RESULT + result);
		System.out.println(USER_TRY_COUNT_PHRASE + String.format("%d", count));
	}

	public void printError(String errorMessage) {
		System.out.println(errorMessage);
	}
}
