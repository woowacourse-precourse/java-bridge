package bridge;

import java.util.List;

public class Bridge {

  private final List<Direction> directions;

  public Bridge(List<Direction> directions) {
    this.directions = directions;
  }

  public List<Direction> getDirections() {
    return directions;
  }
}
