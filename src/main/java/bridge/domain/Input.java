package bridge.domain;

import bridge.domain.command.BridgeMoveCommand;
import bridge.domain.command.ReTryCommand;
import bridge.domain.command.SetBridgeSizeCommand;

public interface Input {

  SetBridgeSizeCommand readBridgeSize();
  BridgeMoveCommand readMoving();

  ReTryCommand readGameCommand();
}
