package bridge.exception;

import bridge.domain.model.Bridge;

public class ControllerException {

    Bridge bridge = new Bridge();

    public void sameBridgeLength(int length) throws IllegalArgumentException {
        if (length != bridge.getSize()) {
            throw new IllegalArgumentException("[ERROR] Bridge Length is Not Same");

        }
    }

}
