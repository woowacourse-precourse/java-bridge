package bridge;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
        try {
            gameController.start();
            gameController.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}