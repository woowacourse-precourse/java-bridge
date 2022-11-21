package bridge.enums;

public enum InGameMessage {

  START("다리 건너기 게임을 시작합니다."),
  INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
  INPUT_DIRECTION("이동할 칸을 선택해주세요. (" + ControlKey.UP.getPair() + ", " + ControlKey.DOWN.getPair() + ")"),
  INPUT_RETRY_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (" + ControlKey.RETRY.getPair() + ", " + ControlKey.QUIT.getPair() + ")"),
  RESULT("최종 게임 결과"),
  SUCCESS_OR_FAILURE("게임 성공 여부: "),
  TRY_COUNT("총 시도한 횟수: "),
  SUCCESS("성공", true),
  FAILURE("실패", false);


  private String message;
  private boolean success;

  InGameMessage(String message) {
    this.message = message;
  }
  InGameMessage(String message, boolean success) {
    this.message = message;
    this.success = success;
  }

  public String getMessage() {
    return message;
  }
}
