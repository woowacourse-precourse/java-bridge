package bridge.controller;

import bridge.view.InputView;

public class InputController {

    public int getBridgeSize() {
        while(true) {
            try {
                String bridgeSize = InputView.readBridgeSize();

            } catch(IllegalArgumentException e) {

            }
        }
    }
}
