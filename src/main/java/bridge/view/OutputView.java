package bridge.view;

import bridge.domain.Direction;

import java.util.List;

import static bridge.domain.GameMessage.*;

/** 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다. */
public class OutputView {
  public static final String BRIDGE_LEFT_SHAPE = "[ ";
  public static final String BRIDGE_CENTER_SHAPE = " | ";
  public static final String BRIDGE_RIGHT_SHAPE = " ]";
  public static final String BRIDGE_BLACK_SHAPE = " ";
  public static final String MOVE_SUCCESS_SIGN = "O";
  public static final String MOVE_FAIL_SIGN = "X";
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
  public static void printMap(List<String> moveStatus, List<String> bridge) {
    String upLine = BRIDGE_LEFT_SHAPE;
    String downLine = BRIDGE_LEFT_SHAPE;

    for (int i = 0; i < moveStatus.size(); i++) {
      if (i != 0) {
        upLine += BRIDGE_CENTER_SHAPE;
        downLine += BRIDGE_CENTER_SHAPE;
      }
      String moveDir = moveStatus.get(i);
      String bridgeDir = bridge.get(i);
      upLine += getString(moveDir, bridgeDir, true);
      downLine += getString(moveDir, bridgeDir, false);
    }
    upLine += BRIDGE_RIGHT_SHAPE;
    downLine += BRIDGE_RIGHT_SHAPE;
    System.out.println(upLine + "\n" + downLine);
    printBlankLine();
  }

  /** 게임의 최종 결과를 정해진 형식에 맞춰 출력한다. */
  public static void printFinalResult(List<String> moveStatus, List<String> bridge) {
    System.out.println(GAME_RESULT_MESSAGE.getMessage());
    printMap(moveStatus, bridge);
  }

  private static String getSuccessOrFailure(String moveDir, String bridgeDir) {
    if(moveDir.equals(bridgeDir)) {
      return MOVE_SUCCESS_SIGN;
    }
    return MOVE_FAIL_SIGN;
  }

  private static String getString(String moveDir, String bridgeDir, boolean isUp){
    String successOrFail = getSuccessOrFailure(moveDir, bridgeDir);
    if (moveDir.equals(Direction.UP.getDirection())) {
      if(isUp) return successOrFail;
      return BRIDGE_BLACK_SHAPE;
    } else {
      if(isUp) return BRIDGE_BLACK_SHAPE;
      return successOrFail;
    }
  }
}
