package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
	private static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
	private static final String MOVING_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
	private static final String GAME_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도:R, 종료: Q)";
	private static final String FINAL_GAME_RESULT_MESSAGE = "최종 게임 결과";
	private static final String GAME_SUCCESS_MEESAGE = "게임 성공 여부: 성공";
	private static final String GAME_FAILURE_MEESAGE = "게임 성공 여부: 실패";
	private static final String NUMBER_OF_ATTEMPTS_MESSAGE = "총 시도한 횟수: ";

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap() {
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(boolean gameResult, int attemptNumber) {
		System.out.println(FINAL_GAME_RESULT_MESSAGE);

		if (gameResult == true)
			System.out.println(GAME_SUCCESS_MEESAGE);
		if (gameResult == false)
			System.out.println(GAME_FAILURE_MEESAGE);
		System.out.println(NUMBER_OF_ATTEMPTS_MESSAGE + attemptNumber);
	}

	public void printStart() {
		System.out.println(START_MESSAGE);
	}

	public void printBridgeSize() {
		System.out.println(BRIDGE_SIZE_MESSAGE);
	}

	public void printMoving() {
		System.out.println(MOVING_MESSAGE);
	}

	public void printGameCommand() {
		System.out.println(GAME_COMMAND_MESSAGE);
	}

	public void printLowerBridge(List<String> lowerBridge) {
		System.out.println("[" + lowerBridge + "]");
	}

	public void printUpperBridge(List<String> upperBridge) {
		System.out.println("[" + upperBridge + "]");
	}
}
