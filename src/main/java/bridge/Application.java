package bridge;

import java.util.List;

public class Application {
    static BridgeGame bridgeGame = new BridgeGame();
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(generator);

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        List<String> bridgeState = bridgeMaker.makeBridge(inputView.readBridgeSize());

        List<String> currentBridgeState=bridgeMaker.initialBridge();
        String choicePosition;
        String retryCommand="실패";
        int countTry=0;
        int count=0;
        String passFail="";
        while (true) {
            if (retryCommand.equals("Q") || count >= bridgeState.size()){
                break;
            }
            currentBridgeState=bridgeMaker.initialBridge();
            countTry++;
            count=0;
            while (true) {
                if (count >= bridgeState.size()) {
                    passFail="성공";
                    break;
                }
                choicePosition = bridgeGame.move();
                currentBridgeState = outputView.printMap(
                        bridgeMaker.addBridge(currentBridgeState, bridgeState.get(count), choicePosition));
                if (currentBridgeState.get(0).contains("X") || currentBridgeState.get(1).contains("X")) {
                    retryCommand = inputView.readGameCommand();
                    break;
                }
                count++;
            }
        }
        outputView.printResult(currentBridgeState,passFail,countTry);
    }
}
