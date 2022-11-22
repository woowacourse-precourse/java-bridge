package bridge;

import bridge.system.DependencyContainer;

public class Application {

    public static void main(String[] args) {
        DependencyContainer.gameController().doGame();
    }
}
