package bridge;

import bridge.controller.GamePlay;
import bridge.domain.enums.Error;
import java.util.NoSuchElementException;

public class Application {

    public static void main(String[] args) {
        try {
            GamePlay gamePlay = new GamePlay();
            gamePlay.bridgeGameStart();
        } catch (NoSuchElementException e) {
            System.out.println(Error.INPUT_DETERMINE.getMessage());
        }
    }
}
