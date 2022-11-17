package bridge;

import bridge.Controller.GameController;

public class Application {

    private static final String GAME_START_SENTENCE = "다리 건너기 게임을 시작합니다.";

    public static void main(String[] args) {
        System.out.println(GAME_START_SENTENCE);
        GameController gameController = new GameController();
        gameController.run();
    }
}

