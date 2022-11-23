package bridge.exception;

public class InvalidGameCommandException extends IllegalArgumentException {
  private static final String INVALID_GAME_COMMAND_MESSAGE = "잘못된 입력입니다.";

  public InvalidGameCommandException() {
    super(INVALID_GAME_COMMAND_MESSAGE);
  }
}
