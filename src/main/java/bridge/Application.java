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
        boolean stageResult;
        boolean retryPlay = true;
        int triedCounter = 0;
        int round;

        while (retryPlay) {
            retryPlay = false;
            triedCounter++;
            for (round = 0; round < newBridge.size(); round++) {
                String userAnswer = inputs.readMovingWithValidityCheck();
                stageResult = bridgeGame.move(userAnswer, newBridge, round);
                outputs.designBridgeMap(newBridge, currentResult, stageResult, round);
                outputs.printMap(currentResult);
                if (!stageResult) {
                    retryPlay = whenItsWrong(currentResult);
                    break;
                }//if
            }
            outputs.printResult(newBridge, currentResult, round, triedCounter);
        }//while
    }


    static boolean whenItsWrong(List<String> currentResult) {
        String retryAnswer = inputs.readGameCommandWithValidityCheck();
        boolean retry = bridgeGame.retry(retryAnswer, currentResult);
        return retry;
    }

    static int resetStatus(List<String> currentResult, int triedCounter) { //진행상황 초기화 및 시도 카운터 증가
        currentResult.clear();
        triedCounter = playCounter(triedCounter);
        return triedCounter;
    }

}
