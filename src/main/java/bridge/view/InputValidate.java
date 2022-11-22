package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputValidate {

  public static void isDigitBridgeSize(String strSize) {
    for (int i = 0; i < strSize.length(); i++) {
      if (!Character.isDigit(strSize.charAt(i))) {
        throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
      }
    }
  }

  public static void isInRangeBridgeSize(int bridgeSize) {
    if (bridgeSize < 3 || bridgeSize > 20) {
      throw new IllegalArgumentException("[ERROR] 3 이상 20 이하의 숫자를 입력해 주세요.");
    }
  }

  public static int isValidSize(String userInputSize) {
    isDigitBridgeSize(userInputSize);
    int bridgeSize = Integer.parseInt(userInputSize);
    isInRangeBridgeSize(bridgeSize);
    return bridgeSize;
  }

  // String 길이 검사를 하고, U, P만 들어올 수 있도록
  public static void isValidLength(String inputValue) {
    if (inputValue.length() != 1) {
      throw new IllegalArgumentException("[ERROR] 한 글자만 입력해 주세요.");
    }
  }

  public static void isValidMoving(String inputMovingValue) {
    isValidLength(inputMovingValue);
    if (inputMovingValue.charAt(0) != 'U' && inputMovingValue.charAt(0) != 'D') {
      throw new IllegalArgumentException("[ERROR] 위로 이동을 원하면 U, 아래로 이동을 원하면 D를 입력해 주세요.");
    }
  }

  public static void isValidCommand(String inputCommandValue) {
    isValidLength(inputCommandValue);
    if (inputCommandValue.charAt(0) != 'R' && inputCommandValue.charAt(0) != 'Q') {
      throw new IllegalArgumentException("[ERROR] 재시작을 원하면 R, 끝내기를 원하면 Q를 입력해 주세요.");
    }
  }
}
