package bridge.constant;

public enum Message {
  REQUEST_INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
  REQUEST_INPUT_BRIDGE_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
  REQUEST_INPUT_RETRY_SIGNAL("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
  OUTPUT_RESULT_MESSAGE("\n최종 게임 결과"),
  OUTPUT_SUCCESS_MESSAGE("\n게임 성공 여부: 성공"),
  OUTPUT_FAIL_MESSAGE("게임 성공 여부: 실패"),
  OUTPUT_TRY_COUNT_MESSAGE("총 시도한 횟수: ");
  private final String text;

  Message(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
