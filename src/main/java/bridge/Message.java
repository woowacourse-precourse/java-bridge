package bridge;

public enum Message {
  START("다리 건너기 게임을 시작합니다.\n다리의 길이를 입력해주세요."),
  REQUEST_DIRECTION("이동할 방향을 입력해주세요. (위: U, 아래: D)"),
  RESTART_OR_EXIT("게임을 다시 시작하겠습니까?. (재시도: R, 종료: Q)");

  private final String message;

  Message(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return message;
  }

}
