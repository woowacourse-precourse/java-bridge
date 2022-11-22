package bridge;

import static bridge.configuration.AppConfig.bridgeGameController;

public class Application {

    public static void main(String[] args) {
        bridgeGameController().start();
    }
}
