package bridge;

import bridge.config.NumberGeneratorDependencyContainer;
import bridge.config.NumberGeneratorDependencyContainerImpl;
import bridge.user.GamePlayer;

public class Application {

    public static void main(String[] args) {
        NumberGeneratorDependencyContainer numberGeneratorDependencyContainer
                = new NumberGeneratorDependencyContainerImpl();

        GamePlayer gamePlayer = new GamePlayer(numberGeneratorDependencyContainer);
        gamePlayer.playGame();
    }
}
