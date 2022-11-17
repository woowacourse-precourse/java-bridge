package bridge;

public enum GameMessage {
  GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
  LENGTH_INPUT_MESSAGE("다리의 길이를 입력해주세요."),
  ERROR_MESSAGE("[ERROR] "),
  MOVE_DIR_INPUT_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)");
  private final String message;

  GameMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return this.message;
  }
}
