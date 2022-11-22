package bridge;

import java.util.ArrayList;
import java.util.List;

public class GameControl {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame = new BridgeGame();

    public static List<String> resultBridge = new ArrayList<String>();
    public static int retry;
    private static boolean mainGameResult;
    private boolean endGameResult;

    public void game(){
        startGame();
        retry = 1;
        while(true) {
            resultBridge = mainGame();
            endGameResult = endGame(resultBridge);
            if (!endGameResult) {
                break;
            }
        }
    }

    public void startGame(){
        System.out.println("다리건너기 게임을 시작합니다.\n");
        bridgeMaker.makeBridge(inputView.readBridgeSize());
    }
    public List<String> mainGame() {
        resultBridge = retryReset();
        while (BridgeGame.position < BridgeMaker.bridgeUp.size()) {
            boolean result = bridgeGame.move(inputView.readMoving());
            outputView.printResult(resultBridge);
            if (!result) {
                return resultBridge;}
        }
        mainGameResult = true;
        return resultBridge;
    }
    public boolean endGame( List<String> resultBridge){
        if(!mainGameResult){
            String answerRetry = inputView.readGameCommand();
            if(answerRetry.equals("Q")){
                outputView.wrongResultGame(resultBridge, retry);
                return false;}
            retry++;
            return true;}
        outputView.rightResultGame(resultBridge, retry);
        return false;
    }

    public List<String> retryReset() {
        BridgeGame.position = 0;
        resultBridge = new ArrayList<String>();
        endGameResult = false;
        return resultBridge;
    }
}