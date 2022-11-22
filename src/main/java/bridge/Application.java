package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame(new InputView().readBridgeSize());

        while (!bridgeGame.isExit())
            bridgeGame.move();
    }
}
