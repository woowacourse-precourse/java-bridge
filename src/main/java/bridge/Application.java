package bridge;

import bridge.business.BridgeGame;
import bridge.business.BridgeResult;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

public class Application {
    private final static InputView inputView = new InputView();
    private final static OutputView outputView = new OutputView();
    private final static BridgeGame bridgeGame = new BridgeGame();
    private final static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        beforeGame();

        BridgeResult bridgeResult = new BridgeResult(bridgeGame);
        gameStart(bridgeResult);

        printFinalResult(bridgeResult);
    }

    private static void beforeGame() {
        outputView.printStart();

        int bridgeSize = getValidBridgeSize();
        outputView.printSpace();

        makeBridge(bridgeSize);
    }

    private static void makeBridge(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.setBridge(bridge);
    }

    private static void gameStart(BridgeResult bridgeResult){
        while(true){
            startOneGame(bridgeResult);

            if(isFinished(bridgeResult)){
                return;
            }
        }
    }

    private static void startOneGame(BridgeResult bridgeResult) {
        bridgeResult.refresh();

        for(int i=0;i<bridgeGame.getBridge().size();i++){
            move(bridgeResult);
            if(!bridgeResult.isSuccess()){
                return;
            }
        }
    }

    private static void move(BridgeResult bridgeResult) {
        String movingKey = getValidMovingKey();
        bridgeResult.move(movingKey);
        outputView.printMap(bridgeResult.isSuccess(), bridgeResult.getBridge());
    }

    private static boolean isFinished(BridgeResult bridgeResult) {
        if(bridgeResult.isSuccess()){
            return true;
        }
        if(!bridgeGame.retry(getValidRetryKey())){
            return true;
        }
        return false;
    }

    private static void printFinalResult(BridgeResult result) {
        outputView.printEnd();
        outputView.printMap(result.isSuccess(), result.getBridge());
        outputView.printResult(result.isSuccess(), result.getTryCount());
    }

    private static int getValidBridgeSize(){
        while(true){
            try{
               String bridgeSize = getBridgeSize();
                return bridgeGame.validateBridgeSize(bridgeSize);
            }catch (IllegalArgumentException e){
                outputView.printError(e);
            }
        }
    }

    private static String getValidMovingKey() {
        while(true){
            try{
                String movingKey = getMovingKey();
                return bridgeGame.validateMovingKey(movingKey);
            }catch (IllegalArgumentException e){
                outputView.printError(e);
            }
        }
    }

    private static String getValidRetryKey() {
        while(true){
            try{
                String retryKey = getRetryKey();
                return bridgeGame.validateMovingKey(retryKey);
            }catch (IllegalArgumentException e){
                outputView.printError(e);
            }
        }
    }

    private static String getBridgeSize() {
        outputView.printLength();
        String bridgeSize = inputView.readBridgeSize();
        outputView.printValue(bridgeSize);

        return bridgeSize;
    }

    private static String getMovingKey() {
        outputView.printNextStep();
        String movingKey = inputView.readMoving();
        outputView.printValue(movingKey);

        return movingKey;
    }

    private static String getRetryKey() {
        outputView.printReStart();
        String retryKey = inputView.readGameCommand();
        outputView.printValue(retryKey);

        return retryKey;
    }
}
