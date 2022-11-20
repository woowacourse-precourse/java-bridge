package bridge;

import bridge.controller.GameContoller;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameContoller gameContoller = new GameContoller();
        gameContoller.run();
    }
}
