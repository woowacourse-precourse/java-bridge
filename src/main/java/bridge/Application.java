package bridge;

import java.util.List;

public class Application {

    public static class View{
        private OutputView outputView;
        private InputView inputView;

        public View(OutputView outputView, InputView inputView){
            this.outputView = outputView;
            this.inputView = inputView;
        }

        public InputView getInputView(){
            return this.inputView;
        }
        public OutputView getOutputView(){
            return this.outputView;
        }
    }
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeGame bridgeGame = new BridgeGame();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        View view = new View(outputView, inputView);

        phase1_gameInitialize(outputView, bridgeGame);
        phase2_setBridge(inputView,bridgeMaker,bridgeGame);
        phase3_getMoving(view, bridgeGame);
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

    public static void phase3_getMoving(View view, BridgeGame bridgeGame){
        Boolean canSuccess = checkIsSuccess(view.getOutputView(), view.getInputView(), bridgeGame);
        List<String> tmpBridge = bridgeGame.move(canSuccess);
        Boolean finish = bridgeGame.checkFinish();
        view.getOutputView().printMap(tmpBridge, bridgeGame.getNowMoving());
        if (canSuccess == false) retry(view, bridgeGame, tmpBridge);
        if (canSuccess == true && finish == true) {
            end(view.getOutputView(), tmpBridge, bridgeGame.getNowMoving());
            printIsSuccessful(view.getOutputView(), "성공");
            printTryCount(bridgeGame, view.getOutputView());}
        if (canSuccess == true && finish == false) phase3_getMoving(view, bridgeGame);}
    public static Boolean checkIsSuccess(OutputView outputView, InputView inputView, BridgeGame bridgeGame){
        outputView.printGetSpaceToMove();
        String nextMove = inputView.readMoving();
        return bridgeGame.checkCanSuccess(nextMove);
    }
    public static void retry(View view, BridgeGame bridgeGame, List<String> tmpBridge){
        view.getOutputView().printGetTryAgain();
        String tryAgain = view.getInputView().readGameCommand();
        if (tryAgain.equals("Q")) {
            end(view.getOutputView(), tmpBridge, bridgeGame.getNowMoving());
            printIsSuccessful(view.getOutputView(), "실패");
            printTryCount(bridgeGame, view.getOutputView());
        }
        if (tryAgain.equals("R")){
            bridgeGame.retry();
            phase3_getMoving(view, bridgeGame);
        }
    }
    public static void end(OutputView outputView, List<String> tmpBridge, String nowMoving){
        outputView.printFinalResult();
        outputView.printMap(tmpBridge, nowMoving);
    }
    public static void printIsSuccessful(OutputView outputView, String result){
        outputView.printIsSuccessful(result);
    }
    public static void printTryCount(BridgeGame bridgeGame, OutputView outputView){
        int gameCount = bridgeGame.getGameCount();
        outputView.printTryCount(gameCount);
    }
}
