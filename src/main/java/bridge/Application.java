package bridge;

import controller.GameController;

public class Application {
    //TODO 리드미 확인할 것
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            GameController gameController = new GameController();
            gameController.control();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
