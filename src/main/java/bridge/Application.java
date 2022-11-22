package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        OutputGameMessage.GAME_START_MESSAGE.printMessage();
        bridgeGame.start();
    }
}
