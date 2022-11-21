package view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 */
	public void printMap(String map) {
		System.out.println(map);
		printEmptyLine();
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 */
	public void printResult(String result, boolean isSuccess, int count) {
		printFinalResultMap(result);
		printSuccessOrFail(isSuccess);
		printTotalPlayCount(count);
	}

	private void printFinalResultMap(String result) {
		System.out.println(ViewConstant.FINAL_RESULT_MESSAGE);
		System.out.println(result);
		printEmptyLine();
	}

	private void printSuccessOrFail(boolean isSuccess) {
		System.out.print(ViewConstant.SUCCESS_OR_FAIL_MESSAGE);
		if (isSuccess) {
			System.out.println(ViewConstant.SUCCESS);
		}
		if (!isSuccess) {
			System.out.println(ViewConstant.FAIL);
		}
	}

	private void printTotalPlayCount(int count) {
		System.out.printf(ViewConstant.TOTAL_PLAY_COUNT_MESSAGE);
		System.out.println(count);
	}

	public void printStartMessage() {
		System.out.println(ViewConstant.GAME_START_MESSAGE);
		printEmptyLine();
	}

	private void printEmptyLine() {
		System.out.println();
	}

	public void printErrorLog(IllegalArgumentException e) {
		System.out.println(e.getMessage());
	}
}
