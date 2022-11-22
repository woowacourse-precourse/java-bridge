package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static InputView inputs = new InputView();
    static OutputView outputs = new OutputView();
    static BridgeGame bridgeGame = new BridgeGame();

    public static List<String> buildBridge() {
        InputView inputs = new InputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker newBridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> newBridge;
        int size = inputs.readBridgeSizeWithValidityCheck();
        newBridge = newBridgeMaker.makeBridge(size); // 입력 받은 길이의 다리 빌드
        System.out.println(newBridge); // 다리 출력 (디버그)
        return newBridge;
    }

    public static int playCounter(int triedCounter) {
        triedCounter++;
        return triedCounter;
    }

    public static void main(String[] args) {
        List<String> currentResult = new ArrayList<>();
        List<String> newBridge = buildBridge();
        boolean retryPlay = true;
        int triedCounter = 0;
        while (retryPlay) {
            triedCounter++;
            retryPlay = gamePlay(newBridge,currentResult,triedCounter);
        }
    }

    static boolean gamePlay(List<String> newBridge, List<String> currentResult, int triedCounter) {
        int round;
        boolean retryPlay=false;
        for (round = 0; round < newBridge.size(); round++) {
            boolean stageResult = gamePlayMoving(newBridge, currentResult,round);
            if (!stageResult) {
                retryPlay = whenItsWrong(currentResult);
                break;
            }
        }
        printResultOrNot(newBridge, currentResult, round, triedCounter, retryPlay);
        return retryPlay;
    }

    static boolean gamePlayMoving(List<String>newBridge,List<String> currentResult, int round){
        String userAnswer = inputs.readMovingWithValidityCheck();
        boolean stageResult = bridgeGame.move(userAnswer, newBridge, round);
        outputs.designBridgeMap(newBridge, currentResult, stageResult, round);

        return stageResult;
    }
    static void printResultOrNot(List<String> newBridge, List<String> currentResult, int round, int triedCounter, boolean retryPlay) {
        if (!retryPlay) {
            outputs.printResult(newBridge, currentResult, round, triedCounter);
        }
    }
    static boolean whenItsWrong(List<String> currentResult) {
        String retryAnswer = inputs.readGameCommandWithValidityCheck();
        boolean retry = bridgeGame.retry(retryAnswer, currentResult);
        return retry;
    }
}
