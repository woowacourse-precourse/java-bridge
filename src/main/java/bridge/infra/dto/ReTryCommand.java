package bridge.infra.dto;

public class ReTryCommand {

  private final String signal;

  private final String RETRY_SIGNAL = "R";
  private final String QUIT_SIGNAL = "Q";

  public String getSignal() {
    return signal;
  }

  public ReTryCommand(String signal) {
    validate(signal);
    this.signal = signal;
  }

  private void validate(String signal) {
    if (isNull(signal) || !isMatchSignal(signal)) {
      throw new IllegalArgumentException("정확한 값을 입력해주세요");
    }
  }

  private boolean isNull(String str) {
    return str == null;
  }

  private boolean isMatchSignal(String str) {
    return str.equals(RETRY_SIGNAL) || str.equals(QUIT_SIGNAL);
  }

  public boolean isReTry() {
    return signal.equals(RETRY_SIGNAL);
  }
}
