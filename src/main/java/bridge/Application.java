package bridge;

public class Application {
    public static void main(String[] args) {
        try {
            new BridgeGame();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
