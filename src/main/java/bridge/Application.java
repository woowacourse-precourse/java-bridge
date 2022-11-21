package bridge;

public class Application {


    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        try {
            bridgeGame.start();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
