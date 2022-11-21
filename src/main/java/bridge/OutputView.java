package bridge;

/**
 * 제공된 OutputView 클래스를 활용해 구현해야 한다.
 * OutputView의 패키지는 변경할 수 있다.
 * OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 값 출력을 위해 필요한 메서드를 추가할 수 있다.
 */

import static bridge.Constants.*;

import java.util.HashMap;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
	private static HashMap<String, String> status = new HashMap<>();
	static BridgeStatus bridgeStatus = BridgeStatus.getInstance();

	/**
	 * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public static HashMap<String, String> printMap(String userSelectedCell, String bridgeLetter) {
		status = bridgeStatus.loadStatus(userSelectedCell, bridgeLetter);
		return status;
	}

	/**
	 * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
	 * <p>
	 * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
	 */
	public static HashMap<String, String> printResult() {
		status = getStatus();
		return status;
	}

	private static HashMap<String, String> getStatus() {
		return bridgeStatus.loadStatus(NULL, NULL);
	}

	public static String printSuccessOrNot() {
		if (bridgeStatus.isSuccess()) {
			return SUCCESS_MESSAGE;
		}
		return FAIL_MESSAGE;
	}

	public static int printTotalGameCount() {
		return bridgeStatus.getTotalGameCount();
	}

	public static void printStartGame() {
		System.out.println(OUTPUT_START_GAME);
	}

	public static void printFinalGameResult() {
		System.out.println(OUTPUT_GAME_RESULT);
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}
}
