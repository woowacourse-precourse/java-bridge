package bridge;

import bridge.constants.GuideMessage;
import bridge.controller.GameManager;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(GuideMessage.START_MESSAGE);
        GameManager gameManager = new GameManager();
        try {
            gameManager.initGameSetting();
            gameManager.startGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
