package bridge;

import java.util.List;

public class Application {
    static BridgeGame bridgeGame = new BridgeGame();
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(generator);
    static List<String> currentBridgeState;
    static String choicePosition;
    static String retryCommand = "";
    static int countTry = 0;
    static int count = 0;
    static String passFail = "";

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        List<String> bridgeState = bridgeMaker.makeBridge(inputView.readBridgeSize());
        while (true) {
            if (passFail.equals("실패")|| passFail.equals("성공")) break;

            currentBridgeState = bridgeMaker.initialBridge();
            countTry++;
            passFail=playGame(bridgeState,currentBridgeState);
        }
        outputView.printResult(currentBridgeState, passFail, countTry);
    }

    private static String playGame(List<String> bridgeState,List<String> currentBridgeState) {
        while (true) {
            if (count >= bridgeState.size()) {
                passFail = "성공";
                break;
            }
            count = moveCount(bridgeState, currentBridgeState);
            if (count == -1) return "실패";
            if (count == 0) return "";
        }
        return passFail;
    }

    private static int moveCount(List<String> bridgeState,List<String> currentBridgeState) {
        choicePosition = bridgeGame.move();
        currentBridgeState = outputView.printMap(
                bridgeMaker.addBridge(currentBridgeState, bridgeState.get(count), choicePosition));
        if (currentBridgeState.get(0).contains("X") || currentBridgeState.get(1).contains("X")) {
            if(inputView.readGameCommand().equals("Q")) {
                return -1;
            }
            return 0;
        }
        count++;
        return count;
    }
}
