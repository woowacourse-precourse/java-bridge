package bridge;

public class Application {
    private static BridgeGame bridgeGame;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        bridgeGame = new BridgeGame(new InputView().readBridgeSize());
        while(!bridgeGame.isEnd()){
            bridgeGame.move();
        }
    }
}
