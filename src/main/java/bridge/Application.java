package bridge;

public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController();
//        try {
            gameController.begin();
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
