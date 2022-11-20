package bridge;

public class Application {

    public final static String ERROR_PREFIX = "[ERROR] ";
    public static void main(String[] args) {
        try {
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
