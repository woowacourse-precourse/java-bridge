package bridge.exception;

public class InvalidBridgeShapeException extends IllegalArgumentException {
  private static final String INVALID_BRIDGE_SHAPE_EXCEPTION_MESSAGE = "다리의 모양이 잘못되었습니다.";

  public InvalidBridgeShapeException() {
    super(INVALID_BRIDGE_SHAPE_EXCEPTION_MESSAGE);
  }
}
