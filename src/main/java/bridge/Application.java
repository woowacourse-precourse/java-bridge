package bridge;

import bridge.controller.BridgeSystem;

public class Application {
    public static void main(String[] args) {
        BridgeSystem bridgeSystem = new BridgeSystem();

        try {
            bridgeSystem.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
