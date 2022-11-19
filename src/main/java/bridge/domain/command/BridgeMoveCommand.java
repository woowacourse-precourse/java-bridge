package bridge.domain.command;

import bridge.domain.BridgeArea;

public class BridgeMoveCommand {

  private BridgeArea area;

  public BridgeMoveCommand(String input) {
    this.area = BridgeArea.of(input);
  }

  public BridgeArea getArea() {
    return area;
  }
}
