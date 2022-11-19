package bridge.view;

import static bridge.config.Message.*;

public class SystemView {

    public void printStartGame() {
        System.out.println(START_GAME);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
