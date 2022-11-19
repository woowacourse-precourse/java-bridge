package bridge;

import bridge.game.GameApplication;

/**
 * 실행해야 하는 main 메서드가 포함된 메인 application 클래스입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
public class Application {

    /**
     * 실제 실행되는 메인 application 메서드입니다.
     */
    public static void main(String[] args) {
        GameApplication gameApplication = new GameApplication();
        gameApplication.inputBridgeLength();
        while (true) {
            boolean isSuccess = gameApplication.singleGame();
            if (isSuccess || !gameApplication.inputIfRestart()) break;
            gameApplication.restart();
        }
        gameApplication.printTotalResult();
    }
}
