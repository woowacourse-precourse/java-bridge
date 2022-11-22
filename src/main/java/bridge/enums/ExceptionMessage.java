package bridge.enums;

public enum ExceptionMessage {

  ERROR("[ERROR] "),
  NULL("입력값이 null입니다."),
  NOT_A_NUMBER("입력값은 숫자가 아닙니다."),
  NOT_IN_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
  NOT_U_OR_D("입력값이 U 또는 D가 아닙니다."),
  NOT_R_OR_Q("입력값이 R 또는 Q가 아닙니다.");

  private String message;

  ExceptionMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}
