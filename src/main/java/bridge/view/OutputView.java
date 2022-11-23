package bridge.view;

import static bridge.domain.GameMessage.*;

import bridge.domain.BridgeGame;
import bridge.domain.Map;

/** 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다. */
public class OutputView {
  public static final String GAME_SUCCESS_STRING = "성공";
  public static final String GAME_FAIL_STRING = "실패";

  public static void printGameStartMessage() {
    System.out.println(GAME_START_MESSAGE.getMessage());
  }

  public static void printLengthInputMessage() {
    printBlankLine();
    System.out.println(LENGTH_INPUT_MESSAGE.getMessage());
  }

  public static void printBlankLine() {
    System.out.println();
  }

  public static void printErrorMessage(Exception e) {
    printBlankLine();
    System.out.println(ERROR_MESSAGE.getMessage() + e.getMessage());
  }

  public static void printMoveDirInputMessage() {
    System.out.println(MOVE_DIR_INPUT_MESSAGE.getMessage());
  }

  public static void printCheckRetryInputMessage() {
    System.out.println(CHECK_RETRY_INPUT_MESSAGE.getMessage());
  }

  public static void printGameSuccessOrFailure(boolean isSuccess) {
    System.out.println(
        GAME_SUCCESS_OR_FAILURE_MESSAGE.getMessage() + getSuccessOrFailure(isSuccess));
  }

  public static void printTotalTryCount(int count) {
    System.out.println(TOTAL_TRY_COUNT_MESSAGE.getMessage() + count);
  }

  private static String getSuccessOrFailure(boolean isSuccess) {
    if (isSuccess) return GAME_SUCCESS_STRING;
    return GAME_FAIL_STRING;
  }

  /** 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다. */
  public static void printMap(Map map) {
    System.out.println(map.getMapString());
    printBlankLine();
  }

  /** 게임의 최종 결과를 정해진 형식에 맞춰 출력한다. */
  public static void printResult(BridgeGame bridgeGame, int tryCount) {
    System.out.println(GAME_RESULT_MESSAGE.getMessage());
    printMap(bridgeGame.getMap());
    printGameSuccessOrFailure(bridgeGame.isTrySuccess());
    printTotalTryCount(tryCount);
  }
}
