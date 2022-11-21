package bridge;

import bridge.controller.BridgeControl;

public class Application {

    public static void main(String[] args) {
        BridgeControl bridgeControl = new BridgeControl();
        bridgeControl.execute();
    }
}