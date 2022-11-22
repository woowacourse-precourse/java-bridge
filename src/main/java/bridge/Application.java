package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            GameController gameController = new GameController();
            gameController.start();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e);
        }
    }
}
