package bridge;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeGameRunner bridgeGameRunner = new BridgeGameRunner();
            bridgeGameRunner.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
