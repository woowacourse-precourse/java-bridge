package bridge;

import bridge.controller.GameSystem;

public class Application {

    public static void main(String[] args) {
        GameSystem system = new GameSystem();
        system.inputBridgeLength();
        system.calculate();
        system.result();
    }
}
