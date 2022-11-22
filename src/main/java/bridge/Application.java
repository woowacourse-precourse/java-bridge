package bridge;

public class Application {
    public static void main(String[] args) {
        System.out.println(Constant.START_GAME);
        try {
            GameController.setGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
