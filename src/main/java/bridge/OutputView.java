package bridge;

import static bridge.GameMessage.*;

/** 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다. */
public class OutputView {

  public static void printGameStartMessage() {
    System.out.println(GAME_START_MESSAGE.getMessage());
  }

  public static void printLengthInputMessage() {
    printBlankLine();
    System.out.println(LENGTH_INPUT_MESSAGE.getMessage());
  }

  private static void printBlankLine() {
    System.out.println();
  }

  public static void printErrorMessage(Exception e) {
    printBlankLine();
    System.out.println(ERROR_MESSAGE.getMessage() + e.getMessage());
  }

  public static void printMoveDirInputMessage() {
    printBlankLine();
    System.out.println(MOVE_DIR_INPUT_MESSAGE.getMessage());
  }

  public static void printCheckRetryInputMessage() {
    printBlankLine();
    System.out.println(CHECK_RETRY_INPUT_MESSAGE.getMessage());
  }

  /**
   * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
   *
   * <p>출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
   */
  public static void printMap() {}

  /**
   * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
   *
   * <p>출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
   */
  public void printResult() {}
}
