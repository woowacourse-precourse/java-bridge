package bridge;

import bridge.service.BridgeGameService;

public class Application {

    public static void main(String[] args) {
        try {
            new BridgeGameService().start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
