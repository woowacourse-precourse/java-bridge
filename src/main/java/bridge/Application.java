package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            GameController controller = new GameController();
            controller.play();
        } catch (IllegalArgumentException e) {
//            System.out.println("[ERROR] " + e);
        }
    }
}
