package bridge.domain;

import java.util.Arrays;

public enum Direction {
  UP(1, "U"),
  DOWN(0, "D");

  private final int moveInput;
  private final String moveOutput;

  Direction(int moveInput, String moveOutput) {
    this.moveInput = moveInput;
    this.moveOutput = moveOutput;
  }

  public static Direction of(int input) {
    return Arrays.stream(Direction.values())
            .filter(direction -> direction.moveInput == input)
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 올바른 생성값이 아닙니다."));
  }
  
  public String getMoveOutput() {
    return this.moveOutput;
  }

  public int getMoveInput() {
    return this.moveInput;
  }
}
