package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            GameController gameController = new GameController();
            gameController.start();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e);
        }
    }
}
