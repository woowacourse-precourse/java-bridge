package bridge;

import bridge.exception.InvalidGameCommandException;

public enum GameCommand {
  RETRY("R"),
  QUIT("Q");
  private final String command;

  GameCommand(String command) {
    this.command = command;
  }

  public static void validateGameCommand(String inputGameCommand) {
    for (GameCommand gameCommand : GameCommand.values()) {
      if (gameCommand.command.equals(inputGameCommand)) {
        return;
      }
    }
    throw new InvalidGameCommandException();
  }

  public String getCommand() {
    return this.command;
  }
}
