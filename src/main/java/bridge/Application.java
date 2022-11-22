package bridge;


import java.util.ArrayList;
import java.util.List;

public class Application {

    public void gamePlay() {

    }

    static InputView inputs = new InputView(); // 다리 입력 길이 객체

    static OutputView outputs = new OutputView();
    static BridgeGame bridgeGame = new BridgeGame();

    public static List<String> buildBridge() {
        InputView inputs = new InputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator(); // 난수 생성 객체
        BridgeMaker newBridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> newBridge;
        int size = inputs.readBridgeSizeWithValidityCheck(); //다리 길이 입력
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
        int triedCounter = 1;
        int round;

        while (retryPlay) {
            retryPlay = false;
            for (round = 0; round < newBridge.size(); round++) {
                String userAnswer = inputs.readMovingWithValidityCheck();
                stageResult = bridgeGame.move(userAnswer, newBridge, round);
                outputs.designBridgeMap(newBridge, currentResult, stageResult, round);
                outputs.printMap(currentResult);
                if (!stageResult) {
                    retryPlay = whenItsWrong(currentResult, triedCounter);
                    break;
                }//if

                outputs.printResult(newBridge, currentResult, round, triedCounter);

            }//for
        }//while
    }


    static boolean whenItsWrong(List<String> currentResult, int triedCounter) {
        String retryAnswer = inputs.readGameCommandWithValidityCheck();
        boolean retry = bridgeGame.retry(retryAnswer, currentResult, triedCounter);
        return retry;
    }

    static int resetStatus(List<String> currentResult, int triedCounter) { //진행상황 초기화 및 시도 카운터 증가
        currentResult.clear();
        triedCounter = playCounter(triedCounter);
        return triedCounter;
    }

}
