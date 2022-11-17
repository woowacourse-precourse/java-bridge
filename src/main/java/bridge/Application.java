package bridge;

import bridge.service.BridgeGameConsole;

public class Application {

    public static void main(String[] args) {
        BridgeGameConsole gameConsole = new BridgeGameConsole();
        gameConsole.run();
    }
}
