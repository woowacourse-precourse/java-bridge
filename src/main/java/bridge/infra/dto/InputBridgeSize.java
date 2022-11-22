package bridge.infra.dto;

public class InputBridgeSize {

  private final int size;

  public InputBridgeSize(String str) {
    validateIsNumeric(str);
    this.size = Integer.parseInt(str);
  }

  private void validateIsNumeric(String str) {
    if (str == null || !str.matches("[0-9]*")) {
      throw new IllegalArgumentException("숫자를 입력해야 합니다.");
    }
  }

  public int getSize() {
    return size;
  }
}
