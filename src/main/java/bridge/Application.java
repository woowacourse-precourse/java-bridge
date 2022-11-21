package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGameRunner instance = BridgeGameRunner.getInstance();
        try {
            instance.run();
        } catch (Exception e) {
            System.out.println("[ERROR]" + e.getMessage());
        }
    }
}
