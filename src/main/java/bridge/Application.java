package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGameController bridgeGameController = new BridgeGameController();
        bridgeGameController.start();
//        try {
//            bridgeGameController.start();
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
    }
}
