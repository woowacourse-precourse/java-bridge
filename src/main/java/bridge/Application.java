package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGame.getBridgeGame().runGame();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
