package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame();
        int totalAttempt = 1;

        bridgeGame.startGame(); // 시작 문구
        int bridgeSize;
        while(true){
            bridgeSize = new OutputView().inputStringCheckMessage();
            System.out.println();
            if (!new OutputView().lenCheckMessage(bridgeSize)) {
                break;
            }
        }
        List<String> answerBridge = bridgeMaker.makeBridge(bridgeSize); // 만들어진 정답 다리

        boolean retryCheck;
        while(true) {
            retryCheck = bridgeGame.cycleBridge(answerBridge, totalAttempt, " \n ");
            if(retryCheck){
                totalAttempt++;
            }
            else{
                break;
            }
        }

    }
}
