package bridge.domain;

public class InputChecker {

  public static void checkMoveCMD(String cmd) throws IllegalArgumentException {
    if (!cmd.matches("[UD]")) {
      throw new IllegalArgumentException("입력 문자는 U와 D 중 하나여야 합니다.");
    }
  }

  public static void checkIsNumber(String input) throws IllegalArgumentException {
    if (!input.matches("^[0-9]+$")) {
      throw new IllegalArgumentException("다리 길이는 숫자여야 합니다.");
    }
  }
  public static void checkIsInRange(int num) throws IllegalArgumentException{
    if(num>20||num<3){
      throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
  }
  public static void checkGameCMD(String cmd)throws IllegalArgumentException {
    if (!cmd.matches("[RQ]")) {
      throw new IllegalArgumentException("입력 문자는 R와 Q 중 하나여야 합니다.");
    }
  }
}
