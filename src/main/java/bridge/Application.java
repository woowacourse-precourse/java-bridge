package bridge;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.gameStart();
        GameConstructor gameConstructor = new GameConstructor();
        BridgeGame bridgeGame = new BridgeGame(gameConstructor);
        bridgeGame.play();

    }
}
