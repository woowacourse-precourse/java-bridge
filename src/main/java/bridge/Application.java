package bridge;

import bridge.controller.GameSystem;

public class Application {

    public static void main(String[] args) {
        GameSystem system = new GameSystem();
        system.welcome();
        system.inputBridgeLength();
        system.makeBridge();
        system.calculate();
        system.result();
    }
}
