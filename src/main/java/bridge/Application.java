package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGameMachine bridgeGameMachine= new BridgeGameMachine();

        bridgeGameMachine.setUpGame();
        bridgeGameMachine.gameStart();
        bridgeGameMachine.gameFinish();
    }
}
