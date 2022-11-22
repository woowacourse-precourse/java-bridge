package bridge;

public class Cross {

  private final Direction direction;
  private final boolean canCross;

  public Cross(Direction direction, boolean canCross) {
    this.direction = direction;
    this.canCross = canCross;
  }

  public Direction getDirection() {
    return direction;
  }

  public boolean isCanCross() {
    return canCross;
  }
}