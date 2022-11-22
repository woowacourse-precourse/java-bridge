package bridge;

import controller.GameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 리드미 확인할 것
        // TODO: 요구사항 제발 제대로 찬찬히 읽어보기
        GameController gameController = new GameController();
        gameController.control();
    }
}
