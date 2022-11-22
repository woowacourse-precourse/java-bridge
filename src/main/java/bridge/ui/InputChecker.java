package bridge.ui;

public class InputChecker {

  /**
   * 입력받은 문자열이 U 또는 D인지 확인하는 메서드
   *
   * @param cmd
   * @throws IllegalArgumentException
   */
  public static void checkMoveCMD(String cmd) throws IllegalArgumentException {
    if (!cmd.matches("[UD]")) {
      throw new IllegalArgumentException("입력 문자는 U와 D 중 하나여야 합니다.");
    }
  }

  /**
   * 입력받은 문자열이 숫자인지 확인하는 메서드
   *
   * @param input
   * @throws IllegalArgumentException
   */
  public static void checkIsNumber(String input) throws IllegalArgumentException {
    if (!input.matches("^[0-9]+$")) {
      throw new IllegalArgumentException("다리 길이는 숫자여야 합니다.");
    }
  }

  /**
   * 입력받은 숫자가 3과 20 사이의 수인지 확인하는 메서드
   *
   * @param num
   * @throws IllegalArgumentException
   */
  public static void checkIsInRange(int num) throws IllegalArgumentException {
    if (num > 20 || num < 3) {
      throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
  }

  /**
   * 입력받은 문자열이 R 또는 Q인지 확인하는 메서드
   *
   * @param cmd
   * @throws IllegalArgumentException
   */
  public static void checkGameCMD(String cmd) throws IllegalArgumentException {
    if (!cmd.matches("[RQ]")) {
      throw new IllegalArgumentException("입력 문자는 R와 Q 중 하나여야 합니다.");
    }
  }
}
