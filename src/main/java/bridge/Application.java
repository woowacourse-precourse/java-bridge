package bridge;

import bridge.controller.GameStarter;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameStarter gameStarter = new GameStarter();
        gameStarter.run();
    }
}
