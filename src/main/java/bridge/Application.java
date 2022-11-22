package bridge;

import static bridge.OutputView.*;
public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();
    }

    public static void phase1_gameStart(OutputView outputView,
                                        BridgeGame bridgeGame){
        outputView.printStartMessage();
        bridgeGame.startGameSetCount();
    }
}
