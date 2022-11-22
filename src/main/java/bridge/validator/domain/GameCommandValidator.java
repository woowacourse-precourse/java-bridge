package bridge.validator.domain;

import bridge.domain.GameCommand;
import bridge.exception.InvalidGameCommandException;

public class GameCommandValidator {
  public static void validate(String inputGameCommand) {
    for (GameCommand gameCommand : GameCommand.values()) {
      if (gameCommand.getCommand().equals(inputGameCommand)) {
        return;
      }
    }
    throw new InvalidGameCommandException();
  }
}
