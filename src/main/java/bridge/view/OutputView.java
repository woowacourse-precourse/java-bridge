package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	private static final String START = "다리 건너기 게임을 시작합니다.";
	private static final String SUCCESS = "성공";
	private static final String FAIL = "실패";
	private static final String FINAL_GAME_RESULT = "최종 게임 결과";
	private static final String TOTAL_REPEAT = "총 시도한 횟수: ";
	private static final String IS_SUCCESS = "게임 성공 여부: ";

	public void printStart() {
		System.out.println(START);
		System.out.println();
	}

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(String map) {
		System.out.println(map);
		System.out.println();
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(String map, Boolean successOfCrossBridge, int repeat) {
		System.out.println(FINAL_GAME_RESULT);
		printMap(map);
		printGameSuccessOrFail(successOfCrossBridge);
		System.out.println(TOTAL_REPEAT + repeat);
	}

	private static void printGameSuccessOrFail(Boolean successOfCrossBridge) {
		if (successOfCrossBridge == true) {
			System.out.println(IS_SUCCESS + SUCCESS);
			return;
		}
		System.out.println(IS_SUCCESS + FAIL);
	}
}
