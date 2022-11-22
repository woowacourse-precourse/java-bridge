package bridge;

import java.util.List;
import java.util.SplittableRandom;

import static bridge.OutputView.*;
public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        phase1_gameInitialize(outputView, bridgeGame);
        phase2_setBridge(inputView,bridgeMaker,bridgeGame);

    }

    public static void phase1_gameInitialize(OutputView outputView,
                                             BridgeGame bridgeGame){
        outputView.printStartMessage();
        bridgeGame.startGameSetCount();
        outputView.printGetBridgeLength();
    }

    public static List<String> phase2_setBridge(InputView inputView,
                                                BridgeMaker bridgeMaker,
                                                BridgeGame bridgeGame){
        int bridgeLength = inputView.readBridgeSize();
        List<String> bridgeAnswer = bridgeMaker.makeBridge(bridgeLength);
        bridgeGame.setBridgeAnswer(bridgeAnswer);
        return bridgeAnswer;
    }

    public static Boolean phase3_getMoving(OutputView outputView,
                                                InputView inputView,
                                                BridgeGame bridgeGame){
        outputView.printGetSpaceToMove();
        String nextMove = inputView.readMoving();
        Boolean canSuccess = bridgeGame.checkCanSuccess(nextMove);
        List<String> tmpBridge = bridgeGame.move(canSuccess);
        outputView.printMap(tmpBridge);

        return canSuccess;
    }
    public static Boolean phase4_whatIsNextAction(Boolean canSuccess,
                                                  OutputView outputView,
                                                  InputView inputView){
        if (canSuccess == false){
            outputView.printGetTryAgain();
            String tryAgain = inputView.readGameCommand();
            if (tryAgain=="Q")
        }
    }
}
