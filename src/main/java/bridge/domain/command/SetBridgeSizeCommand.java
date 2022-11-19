package bridge.domain.command;

public class SetBridgeSizeCommand {

  private final int size;

  public SetBridgeSizeCommand(String str) {
    validateIsNumeric(str);
    validateSize(Integer.parseInt(str));
    this.size = Integer.parseInt(str);
  }

  public int getSize() {
    return size;
  }

  private void validateIsNumeric(String str) {
    if (str == null || !str.matches("[0-9]*")) {
      throw new IllegalArgumentException("숫자를 입력해야 합니다.");
    }
  }

  private void validateSize(int size) {
    final int MIN_SIZE = 3;
    final int MAX_SIZE = 20;
    if (size < MIN_SIZE || size > MAX_SIZE) {
      throw new IllegalArgumentException("다리의 크기가 너무 크거나 작습니다.");
    }
  }
}
