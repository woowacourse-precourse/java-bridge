package bridge.view;

import bridge.domain.BridgeGameResult;

public class OutputView {
	private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
	private static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력하세요.";
	private static final String INPUT_MOVING_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요." + " (위: U, 아래: D)";
	private static final String WHETHER_RESTART_OR_NOT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
	private static final String FINAL_GAME_RESULT = "최종 게임 결과";
	private static final String GAME_SUCCESS_OR_FAIL_MESSAGE = "게임 성공 여부: ";
	private static final String TOTAL_COUNT_MESSAGE = "총 시도한 횟수: ";
	private static final String BLANK = "\n";

	public static void printBridgeGameStart() {
		System.out.println(GAME_START_MESSAGE);
	}

	public static void printInputBridgeSize() {
		System.out.println(INPUT_BRIDGE_SIZE_MESSAGE);
	}

	public static void printInputMoving() {
		System.out.println(INPUT_MOVING_DIRECTION_MESSAGE);
	}

	public static void printMap(final int moveCount) {
		printUpResultMap(moveCount);
		printDownResultMap(moveCount);
		System.out.print(BLANK);
	}

	private static void printUpResultMap(final int moveCount) {
		printOpenBracket();
		for (int i = 0; i < moveCount; i++) {
			System.out.print(BridgeGameResult.getUpGameResultByIndex(i));
			printDivisionBracket(i, moveCount);
		}
		printCloseBracket();
	}

	private static void printDownResultMap(final int moveCount) {
		printOpenBracket();
		for (int i = 0; i < moveCount; i++) {
			System.out.print(BridgeGameResult.getDownGameResultByIndex(i));
			printDivisionBracket(i, moveCount);
		}
		printCloseBracket();
	}

	private static void printOpenBracket() {
		System.out.print("[ ");
	}

	private static void printCloseBracket() {
		System.out.println(" ]");
	}

	private static void printDivisionBracket(final int index, final int moveCount) {
		if (isRightPosition(index, moveCount)) {
			System.out.print(" | ");
		}
	}

	private static boolean isRightPosition(final int index, final int moveCount) {
		return isMoveCountOverOne(moveCount) && !isLastIndex(index, moveCount);
	}

	private static boolean isMoveCountOverOne(final int moveCount) {
		return moveCount > 1;
	}

	private static boolean isLastIndex(final int index, final int moveCount) {
		return index == moveCount - 1;
	}

	public static void printWhetherRestartOrNot() {
		System.out.println(WHETHER_RESTART_OR_NOT_MESSAGE);
	}

	public static void printFinalGameResult() {
		System.out.println(FINAL_GAME_RESULT);
	}

	public static void printResult(final String whetherGameSuccess, final int totalTryCount) {
		printSuccessOrNot(whetherGameSuccess);
		printTotalTryCount(totalTryCount);
	}

	private static void printSuccessOrNot(String whetherGameSuccess) {
		System.out.println(GAME_SUCCESS_OR_FAIL_MESSAGE + whetherGameSuccess);
	}

	private static void printTotalTryCount(int totalTryCount) {
		System.out.println(TOTAL_COUNT_MESSAGE + totalTryCount);
	}
}
