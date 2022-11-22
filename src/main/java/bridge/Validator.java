package bridge;

import java.util.regex.Pattern;

public class Validator {
  private static final String RANGE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
  private static final String NUMBER_ERROR = "[ERROR] 숫자만 입력해주세요.";
  private static final Pattern NUMBER = Pattern.compile("^([0-9])+");

  public static void checkSizeRange(int size) {
    if (isUnderMin(size) || isOverMax(size)) {
      throw new IllegalArgumentException(RANGE_ERROR);
    }
  }

  private static boolean isUnderMin(int size) {
    return size < Bridge.MIN;
  }

  private static boolean isOverMax(int size) {
    return size > Bridge.MAX;
  }

  public static void isNumber(String inputString) {
    if (!NUMBER.matcher(inputString).matches()) {
      throw new IllegalArgumentException(NUMBER_ERROR);
    }
  }
}
