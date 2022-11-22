package bridge.enums;

public enum Range {

  MIN_RANGE(3),
  MAX_RANGE(20);

  private int range;

  Range(int range) {
    this.range = range;
  }

  public int getRange() {
    return range;
  }
}
