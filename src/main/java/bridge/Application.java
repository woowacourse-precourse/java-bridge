package bridge;

public class Application {

    public static void main(String[] args) {
        GameController controller = new DefaultGameController();
        controller.initGame();
        while (true) {
            if (!controller.gameFlow()) {
                break;
            }
        }
    }
}
