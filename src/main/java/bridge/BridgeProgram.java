package bridge;

import java.util.LinkedList;
import java.util.List;

public class BridgeProgram {
  private final List<String> route;
  private final InputView input;
  private final OutputView output;
  private final BridgeMaker bridgeMaker;

  public BridgeProgram(InputView input, OutputView output, BridgeMaker bridgeMaker) {
    this.route = new LinkedList<>();
    this.input = input;
    this.output = output;
    this.bridgeMaker = bridgeMaker;
  }

  public void run() {
    List<String> bridge = bridgeMaker.makeBridge(getBridgeSize());

    boolean isRunning = true;
    while (isRunning) {
      String inputDirection = getInputDirection();

    }
  }
  private int getBridgeSize() {
    output.printMessage(Message.START);
    return input.readBridgeSize();
  }

  private String getInputDirection() {
    output.printMessage(Message.REQUEST_DIRECTION);
    return input.readMoving();
  }
}
