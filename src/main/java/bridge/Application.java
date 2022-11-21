package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static InputView inputView = new InputView();
    static BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();
    static int attemptNum = 1;
    static int currLocation = 0;
    static List<String> record = new ArrayList<String>();
    static boolean continueGame = true;

    public static void playGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        List<String> bridge = getBridge();
        while (currLocation < bridge.size()) {
            String direction = getMove();
            if (!crossBridge(bridge, direction) && continueGame) {
                resetVariables();
            }
        }
        outputView.printResult(attemptNum, currLocation, bridge.size(), record);
    }

    public static List<String> getBridge() {
        int bridgeSize = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public static String getMove() {
        String direction = inputView.readMoving();
        record.add(direction);
        return direction;
    }

    public static void resetVariables(){
        attemptNum += 1;
        currLocation = 0;
        record.clear();
    }

    public static boolean crossBridge(List<String> bridge, String direction) {
        if ((bridgeGame.move(bridge.get(currLocation), direction))) {
            currLocation += 1;
            outputView.printMap(record, true);
            return true;
        }
        continueGame = bridgeGame.retry(inputView.readGameCommand());
        return false;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            playGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
