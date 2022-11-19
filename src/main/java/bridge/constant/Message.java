package bridge.constant;

public enum Message {
  REQUEST_INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요.");

  private String text;

  Message(String text) {
    this.text = text;
  }

  public String getText() {
    return text;
  }
}
