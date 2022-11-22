package bridge.view;

import static bridge.util.Constants.*;
import static bridge.util.Message.*;

import java.util.HashMap;

import bridge.service.BridgeStatus;
import bridge.service.PauseGame;

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

	public static void printStartGameMessage() {
		System.out.println(OUTPUT_START_GAME);
		printNewLine();
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printFinalGameResultMessage() {
		System.out.println(OUTPUT_GAME_RESULT);
	}

	public static void printGameReportMessage() {
		System.out.println(OUTPUT_GAME_REPORT + printSuccessOrNot());
	}

	public static String printSuccessOrNot() {
		if (bridgeStatus.isSuccess()) {
			return SUCCESS_MESSAGE;
		}
		return FAIL_MESSAGE;
	}

	public static void printTotalTryCountMessage() {
		System.out.println(OUTPUT_TOTAL_TRY_COUNT + printTotalAttemptCount());
	}

	public static int printTotalAttemptCount() {
		return PauseGame.getAttemptCount();
	}

	public static void printErrorMessage(String message) {
		System.out.println(message);
	}

	public static void printStatus(HashMap<String, String> status) {
		for (String key : status.keySet()) {
			System.out.print(status.get(key));
			printNewLine();
		}
		printNewLine();
	}

	public static void resetPrintStatus() {
		bridgeStatus.reset();
	}
}
