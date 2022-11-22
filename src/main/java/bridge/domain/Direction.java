package bridge.domain;

public enum Direction {
  UP("U"),
  DOWN("D");
  private final String dir;

  Direction(String directionString) {
    this.dir = directionString;
  }

  public String getDirection() {
    return dir;
  }
}
