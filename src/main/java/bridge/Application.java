package bridge;

public class Application {

    public static void main(String[] args) {
        GameManager gm = new GameManager(new InputView(), new OutputView());
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame;

        gm.showGameTitle();
        bridgeGame = gm.buildBridgeGame(bridgeMaker);
        gm.playGame(bridgeGame);
        gm.showResult(bridgeGame);
   }
}
