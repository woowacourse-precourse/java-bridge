package bridge;

import bridge.constants.GuideMessage;
import bridge.controller.GameManager2;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(GuideMessage.START_MESSAGE);
        AppConfig appConfig = new AppConfig();
        GameManager2 gameManager = new GameManager2();
        gameManager.initGameSetting();
        gameManager.playGame();

    }
}
