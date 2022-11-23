package bridge.domain;

public enum GameMessage {
  GAME_START_MESSAGE("다리 건너기 게임을 시작합니다."),
  LENGTH_INPUT_MESSAGE("다리의 길이를 입력해주세요."),
  ERROR_MESSAGE("[ERROR] "),
  MOVE_DIR_INPUT_MESSAGE(
      String.format(
          "이동할 칸을 선택해주세요. (위: %s, 아래: %s)",
          Direction.UP.getDirection(), Direction.DOWN.getDirection())),
  CHECK_RETRY_INPUT_MESSAGE(
      String.format(
          "게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)",
          GameCommand.RETRY.getCommand(), GameCommand.QUIT.getCommand())),
  GAME_RESULT_MESSAGE("최종 게임 결과"),
  GAME_SUCCESS_OR_FAILURE_MESSAGE("게임 성공 여부: "),
  TOTAL_TRY_COUNT_MESSAGE("총 시도한 횟수: ");
  private final String message;

  GameMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return this.message;
  }
}
