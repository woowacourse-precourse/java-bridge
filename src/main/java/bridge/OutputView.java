package bridge;

import java.util.List;

import static bridge.GameMessage.*;

/** 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다. */
public class OutputView {
  public static final String BRIDGE_LEFT_SHAPE = "[";
  public static final String BRIDGE_CENTER_SHAPE = "|";
  public static final String BRIDGE_RIGHT_SHAPE = "]";
  public static final String BRIDGE_BLACK_SHAPE = " ";
  public static final String MOVE_SUCCESS_SIGN = "O";
  public static final String MOVE_FAIL_SIGN = "X";

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

  /**
   * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
   *
   * <p>출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
   */
  public static void printMap(List<String> moveStatus, List<String> bridge) {
    String upLine = BRIDGE_LEFT_SHAPE;
    String downLine = BRIDGE_LEFT_SHAPE;

    for (int i = 0; i < moveStatus.size(); i++) {
      upLine += " ";
      downLine += " ";
      if (i != 0) {
        upLine += BRIDGE_CENTER_SHAPE + " ";
        downLine += BRIDGE_CENTER_SHAPE + " ";
      }
      String moveDir = moveStatus.get(i);
      String bridgeDir = bridge.get(i);
      if (moveDir.equals(bridgeDir)) {
        if (moveDir.equals(Direction.UP.getDirection())) {
          upLine += MOVE_SUCCESS_SIGN;
          downLine += BRIDGE_BLACK_SHAPE;
        } else {
          upLine += BRIDGE_BLACK_SHAPE;
          downLine += MOVE_SUCCESS_SIGN;
        }
      } else {
        if (moveDir.equals(Direction.UP.getDirection())) {
          upLine += MOVE_FAIL_SIGN;
          downLine += BRIDGE_BLACK_SHAPE;
        } else {
          upLine += BRIDGE_BLACK_SHAPE;
          downLine += MOVE_FAIL_SIGN;
        }
      }
    }
    upLine += " " + BRIDGE_RIGHT_SHAPE;
    downLine += " " + BRIDGE_RIGHT_SHAPE;
    System.out.println(upLine + "\n" + downLine);
    printBlankLine();
  }

  /** 게임의 최종 결과를 정해진 형식에 맞춰 출력한다. */
  public static void printFinalResult(List<String> moveStatus, List<String> bridge) {
    System.out.println(GAME_RESULT_MESSAGE.getMessage());
    printMap(moveStatus, bridge);
  }
}
