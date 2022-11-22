package bridge;

import bridge.domain.Result;
import bridge.domain.bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final BridgeGame bridgeGame = new BridgeGame();
    private final InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    public static int tryNumber = 0;
    private int size;
    void init(){
        try {
            tryNumber=0;
            outputView.startPrint();
            size = inputView.readBridgeSize();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            init();
            return;
        }
        bridgeInit();
    }
    void bridgeInit(){
        try {
            bridgeGame.makeBridge(size);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            bridgeInit();
            return;
        }
        run();
    }
    void run(){
        tryNumber++;
        outputView = new OutputView();
        Result result = null;
        for (int i = 0 ;i<size;i++) {
            result = runGame(i);
            if (printRetry(result.getResultType().getWinLose())) {
                run();
                return;
            }
        }
        endGame(result);
    }
    Result runGame(int index){
        makePlayer();
        Result result = bridgeGame.move(index);
        printResult(result, index);
        return result;
    }
    public void endGame(Result result){
        outputView.printResult(result.getResultType());
    }
    private void printResult(Result result,int index){
        outputView.plusResult(result.getResultType(),index);
        outputView.printMap();
    }
    private boolean printRetry(boolean winLose){
        try {
            if (!winLose) {
                outputView.printRetry();
                return bridgeGame.retry(inputView.readGameCommand());
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return printRetry(winLose);
        }
        return false;
    }
    private void makePlayer(){
        try {
            outputView.gamePrint();
            bridgeGame.makePlayer(inputView.readMoving());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            makePlayer();
        }
    }
}
