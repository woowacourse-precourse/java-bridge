package bridge;

import bridge.controller.GamePlay;
import bridge.domain.enums.Error;
import java.util.NoSuchElementException;

public class Application {

    private static final GamePlay gamePlay = new GamePlay();

    public static void main(String[] args) {
        try {
            gamePlay.bridgeGameStart();
        } catch (NoSuchElementException e) {
            System.out.println(Error.INPUT_DETERMINE.getMessage());
        }
    }
}
