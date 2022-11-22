package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        phase1_gameInitialize(outputView, bridgeGame);
        phase2_setBridge(inputView,bridgeMaker,bridgeGame);
        phase3_getMoving(outputView, inputView, bridgeGame);
    }

    public static void phase1_gameInitialize(OutputView outputView,
                                             BridgeGame bridgeGame){
        outputView.printStartMessage();
        bridgeGame.startGameSetCount();
        outputView.printGetBridgeLength();
    }

    public static void phase2_setBridge(InputView inputView,
                                        BridgeMaker bridgeMaker,
                                        BridgeGame bridgeGame){
        int bridgeLength = inputView.readBridgeSize();
        List<String> bridgeAnswer = bridgeMaker.makeBridge(bridgeLength);
        bridgeGame.setBridgeAnswer(bridgeAnswer);
    }

    public static void phase3_getMoving(OutputView outputView, InputView inputView, BridgeGame bridgeGame){
        Boolean canSuccess = checkIsSuccess(outputView, inputView, bridgeGame);
        List<String> tmpBridge = bridgeGame.move(canSuccess);
        Boolean finish = bridgeGame.checkFinish();
        outputView.printMap(tmpBridge);
        if (canSuccess == false) retry(outputView, inputView, bridgeGame, tmpBridge);
        if (canSuccess == true && finish == true) {
            end(outputView, tmpBridge, "성공");
            printTryCount(bridgeGame, outputView);
        }
        if (canSuccess == true && finish == false) phase3_getMoving(outputView, inputView, bridgeGame);}
    public static Boolean checkIsSuccess(OutputView outputView, InputView inputView, BridgeGame bridgeGame){
        outputView.printGetSpaceToMove();
        String nextMove = inputView.readMoving();
        return bridgeGame.checkCanSuccess(nextMove);
    }
    public static void retry(OutputView outputView, InputView inputView, BridgeGame bridgeGame, List<String> tmpBridge){
        outputView.printGetTryAgain();
        String tryAgain = inputView.readGameCommand();
        if (tryAgain=="Q") {
            end(outputView, tmpBridge, "실패");
            printTryCount(bridgeGame, outputView);
        }
        if (tryAgain=="R"){
            bridgeGame.retry();
            phase3_getMoving(outputView, inputView, bridgeGame);
        }
    }
    public static void end(OutputView outputView, List<String> tmpBridge, String result){
        outputView.printFinalResult();
        outputView.printMap(tmpBridge);
        outputView.printIsSuccessful(result);
    }
    public static void printTryCount(BridgeGame bridgeGame, OutputView outputView){
        int gameCount = bridgeGame.getGameCount();
        outputView.printTryCount(gameCount);
    }
}
