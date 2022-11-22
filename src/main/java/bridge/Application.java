package bridge;


public class Application {

    static BridgeGame bridgeGame;

    public static void main(String[] args) {
        try{
            bridgeGame = new BridgeGame();
            bridgeGame.startGame();
        }
        catch (IllegalArgumentException e){

        }
    }
}
