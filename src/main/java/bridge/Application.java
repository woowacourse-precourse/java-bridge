package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        List<String> bridge;
        List<String> answer;
        boolean retry = true;
        try {
            System.out.println("다리 건너기 게임을 시작합니다.");
            bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
            while (retry) {
                answer = bridgeGame.move(bridge, inputView.readMoving());
                outputView.printMap(bridge, answer);
                if (answer.get(answer.size() - 1).equals("X")) {
                    retry = inputView.readGameCommand();
                }
                if (!retry) {
                    outputView.printResult(bridge, answer, bridgeGame.getNumberOfAttempts());
                }
                if (retry && bridge.size() != answer.size() && answer.get(answer.size() - 1).equals("X")) {
                    bridgeGame.retry();
                }
                if (answer.size() == bridge.size() && answer.get(answer.size() - 1).equals("O")) {
                    outputView.printResult(bridge, answer, bridgeGame.getNumberOfAttempts());
                    break;
                }
            }
        }catch(Exception e){
            System.out.print(e);
        }
    }
}
