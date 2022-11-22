package bridge.domain;

import java.util.Arrays;

public enum BridgeArea {
  U(1), D(0);

  private final int bridgeNumber;

  public int getBridgeNumber() {
    return bridgeNumber;
  }

  BridgeArea(int bridgeNumber) {
    this.bridgeNumber = bridgeNumber;
  }

  public static BridgeArea of(String input) {
    return Arrays.stream(BridgeArea.values()).filter(area -> area.name().equals(input))
        .findAny().orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."));
  }

  public static boolean isMatch(String input) {
    for (BridgeArea area : BridgeArea.values()) {
      if (input.equals(area.name())) {
        return true;
      }
    }
    return false;
  }

  public static BridgeArea of(int number) {
    return Arrays.stream(BridgeArea.values()).filter(area -> area.getBridgeNumber() == number)
        .findAny().orElseThrow(() -> new IllegalArgumentException("잘못된 입력입니다."));
  }
}
