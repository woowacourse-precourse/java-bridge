package bridge;

public enum GameMessage {
  GAME_START_MESSAGE("다리 건너기 게임을 시작합니다.");
  private final String message;

  GameMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return this.message;
  }
}
