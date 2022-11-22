package bridge.validator.domain;

import bridge.domain.Direction;
import bridge.exception.InvalidDirectionException;

public class DirectionValidator {
  public static void validate(String inputDirection) {
    for (Direction direction : Direction.values()) {
      if (direction.getDirection().equals(inputDirection)) {
        return;
      }
    }
    throw new InvalidDirectionException();
  }
}
