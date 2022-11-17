package bridge;

public class Application {

    public static void main(String[] args) {
        try {
           BridgeController bridgeController = new BridgeController();
           bridgeController.setGame();
           bridgeController.proceedGame();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
