package bridge;

import java.util.Objects;
import static bridge.Constants.*;

public class Validator {

  public static final String INPUT_DIRECTION_ERROR = "[ERROR] 방향은 U, D로만 입력 가능합니다.";
  public static final String INPUT_RESTART_ERROR = "[ERROR] (재시도: R, 종료: Q) 두 문자로만 입력 가능합니다.";
  public static final String OUT_OF_RANGE_INPUT_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
  private static final int BRIDGE_LENGTH_LOWER_INCLUSIVE = 3;
  private static final int BRIDGE_LENGTH_UPPER_INCLUSIVE = 20;

  public static void validateBridge(String input) {
    sizeBetween(input);
  }

  public static void validateDirection(String input) {
    if (!Objects.equals(input, BRIDGE_UPPER) && !Objects.equals(input, BRIDGE_LOWER)) {
      throw new IllegalArgumentException(INPUT_DIRECTION_ERROR);
    }
  }

  public static void validateGameCommand(String input) {
    if (!Objects.equals(input, GAME_RESTART) && !Objects.equals(input, GAME_QUIT)) {
      throw new IllegalArgumentException(INPUT_RESTART_ERROR);
    }
  }

  public static void sizeBetween(String input) {
    int inputNum = Integer.parseInt(input);
    if (inputNum < BRIDGE_LENGTH_LOWER_INCLUSIVE || inputNum > BRIDGE_LENGTH_UPPER_INCLUSIVE) {
      throw new IllegalArgumentException(OUT_OF_RANGE_INPUT_ERROR);
    }
  }

}
