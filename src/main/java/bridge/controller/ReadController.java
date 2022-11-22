package bridge.controller;

import bridge.domain.Command;
public interface ReadController {
    int readBridgeSize();
    String readMoving();
    Command readGameCommand();
}
