package bridge.view;

import bridge.model.Moving;

public interface Input {
    String readBridgeSize();

    Moving readMoving();
}
