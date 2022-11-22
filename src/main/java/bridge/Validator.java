package bridge;

import java.util.Objects;

public class Validator {

  public static void validateBridge(String input) {
    sizeBetween(input);
  }

  public static void validateDirection(String input) {
    if (!Objects.equals(input, "U") && !Objects.equals(input, "D")) {
      throw new IllegalArgumentException("[ERROR] 방향은 U, D로만 입력 가능합니다.");
    }
  }

  public static void sizeBetween(String input) {
    int inputNum = Integer.parseInt(input);
    if (inputNum < 3 || inputNum > 20) {
      throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
  }

}
