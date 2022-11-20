package bridge;

import bridge.constants.GuideMessage;
import bridge.controller.GameManager;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(GuideMessage.START_MESSAGE);
        GameManager gameManager = new GameManager();
        gameManager.startGame();

    }
}
