package bridge;

import static bridge.Constants.*;

import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

	public final static String START_ANNOUNCEMENT = "다리 건너기 게임을 시작합니다\n";
	public final static String INPUT_BRIDGE_LENGTH_ANNOUNCEMENT = "다리의 길이를 입력해주세요.";
	public final static String INPUT_MOVEMENT_ANNOUNCEMENT = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
	public final static String GAME_RESULT_ANNOUNCEMENT = "게임 성공 여부: %s";
	public final static String NUMBER_OF_ATTEMPT_ANNOUNCEMENT = "총 시도한 횟수: %d";
	public final static String RESTART_OR_EXIT_ANNOUNCEMENT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	public final static String END_ANNOUNCEMENT = "최종 게임 결과";
	public final static String SUCCESS = "성공";
	public final static String FAILURE = "실패";

	public void printRestartOrExit() {
		System.out.println(RESTART_OR_EXIT_ANNOUNCEMENT);
	}

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printMap(BridgeGame bridgeGame) {
		final Map<SideTypes, List<String>> result = bridgeGame.getResult();
		for (SideTypes sideType : SideTypes.values()) {
			System.out.print(OPEN_SQUARE_BRACKET);
			System.out.print(String.join(VERTICAL_LINE, result.get(sideType)));
			System.out.print(CLOSE_SQUARE_BRACKET);
			System.out.println();
		}
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public void printResult(BridgeGame bridgeGame) {
		System.out.println();
		System.out.println(END_ANNOUNCEMENT);
		printMap(bridgeGame);
		System.out.println();
		System.out.println(String.format(GAME_RESULT_ANNOUNCEMENT, isSuccess(bridgeGame)));
		System.out.println(String.format(NUMBER_OF_ATTEMPT_ANNOUNCEMENT, bridgeGame.getNumberOfAttempt()));
	}

	public void printAnnouncement(String announcement) {
		System.out.println(announcement);
	}

	public void printErrorMessage(String message) {
		System.out.println(ERROR_PREFIX + BLANK + message);
	}

	private String isSuccess(BridgeGame bridgeGame) {
		if (bridgeGame.isSuccess()) {
			return SUCCESS;
		}
		return FAILURE;
	}

}
