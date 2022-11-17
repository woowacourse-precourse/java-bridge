package bridge;

public class Application {

    public static void main(String[] args) {
        try {
           BridgeController bridgeController = new BridgeController();
           bridgeController.setGame();
            do {
                if (bridgeController.setGameResult()) {
                    break;
                }
            }
            while (!bridgeController.isOver());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
