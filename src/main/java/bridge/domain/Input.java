package bridge.domain;

import bridge.domain.command.SetBridgeSizeCommand;

public interface Input {

  SetBridgeSizeCommand readBridgeSize();

}
