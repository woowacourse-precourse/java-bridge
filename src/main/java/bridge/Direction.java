package bridge;

import java.util.Arrays;

public enum Direction {
  D(0),
  U(1);

  private final int number;

  Direction(int number) {
    this.number = number;
  }

  public static Direction findByValue(String value) {
    return Arrays.stream(Direction.values())
            .filter(direction -> direction.toString().equals(value))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("입력한 방향에 해당하는 기능이 없습니다."));

  }

}