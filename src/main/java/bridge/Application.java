package bridge;

import java.util.List;

import static bridge.OutputView.*;
public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    public static void phase1_gameInitialize(OutputView outputView,
                                             BridgeGame bridgeGame){
        outputView.printStartMessage();
        bridgeGame.startGameSetCount();
    }

    public static List<String> phase2_setBridge(OutputView outputView,
                                                InputView inputView,
                                                BridgeMaker bridgeMaker,
                                                BridgeGame bridgeGame){
        outputView.printGetBridgeLength();
        int bridgeLength = inputView.readBridgeSize();
        List<String> bridgeAnswer = bridgeMaker.makeBridge(bridgeLength);
        bridgeGame.setBridgeAnswer(bridgeAnswer);
        return bridgeAnswer;
    }
}
