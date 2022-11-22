package bridge;


import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputs = new InputView(); // 다리 입력 길이 객체
        OutputView outputs = new OutputView();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator(); // 난수 생성 객체
        BridgeMaker newBridge = new BridgeMaker(bridgeNumberGenerator); // 난수를 이용한 다리 빌딩 객체
        List<String> newWholeBridge = new ArrayList<>(); // 빌드한 다리 저장 객체
        BridgeGame bridgeGame = new BridgeGame();
        boolean stageResult;
        boolean retry = true;
        int triedCounter = 1;
        int round;

        List<String> currentResult = new ArrayList<>();
        int size = inputs.readBridgeSizeWithValidityCheck(); //다리 길이 입력
        newWholeBridge = newBridge.makeBridge(size); // 입력 받은 길이의 다리 빌드
        System.out.println(newWholeBridge); // 다리 출력 (디버그)

        while (retry) {
            retry = false;

            for (round = 0; round < size; round++) {
                String userAnswer = inputs.readMovingWithValidityCheck();
                stageResult = bridgeGame.move(userAnswer, newWholeBridge, round);

                outputs.designBridgeMap(newWholeBridge, currentResult, stageResult, round);

                if (!stageResult) {
                    String retryAnswer = inputs.readGameCommandWithValidityCheck();
                    retry = bridgeGame.retry(retryAnswer);
                    if(retry){
                        currentResult.clear();
                        triedCounter++;
                    }
                    break;
                }
                if (round == size - 1) {
                    outputs.printResult(newWholeBridge, currentResult, round, triedCounter);
            }

            }


        }


    }
}
