package bridge.enums;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

public enum ControlKey {
  UP("U", "위", () -> "위: U", 1),
  DOWN("D", "아래", () -> "아래: D", 0),
  RETRY("R", "재시도", () -> "재시도: R"),
  QUIT("Q", "종료", () -> "종료: Q"),
  NOTHING("", "", () -> "");

  private String key;
  private String keyInKorean;
  private int bridgeNum;
  private Supplier<String> getPair;

  ControlKey(String key, String keyInKorean, Supplier<String> getPair) {
    this.key = key;
    this.keyInKorean = keyInKorean;
    this.getPair = getPair;
  }

  ControlKey(String key, String keyInKorean, Supplier<String> getPair, int bridgeNum) {
    this.key = key;
    this.keyInKorean = keyInKorean;
    this.bridgeNum = bridgeNum;
    this.getPair = getPair;
  }

  public String getKey() {
    return key;
  }

  public String getPair() {
    return getPair.get();
  }

  public static String findKeyByBridgeNumber(int bridgeNum) {
    return Arrays.stream(ControlKey.values())
                  .filter(controlKey -> controlKey.bridgeNum == bridgeNum)
                  .map(controlKey -> controlKey.key)
                  .findAny()
                  .orElse(NOTHING.key);
  }
}
