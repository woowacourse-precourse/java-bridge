package bridge.domain;

import bridge.exception.InvalidDirectionException;

public enum Direction {
  UP("U"),
  DOWN("D");
  private final String dir;

  Direction(String directionString) {
    this.dir = directionString;
  }

  public static void validateDirection(String inputDirection) {
    for (Direction direction : Direction.values()) {
      if (direction.dir.equals(inputDirection)) {
        return;
      }
    }
    throw new InvalidDirectionException();
  }

  public String getDirection() {
    return dir;
  }
}
