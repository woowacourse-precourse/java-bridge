package bridge;

import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class Application {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            init();
            gameStart();
            printGameResult();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    private static void init() {
        outputView.printGameStart();
        String input = inputView.readBridgeSize();
        bridgeGame.init(input);
    }

    private static void gameStart() {
        while (true) {
            if (bridgeGame.isGameCompleted()) {
                outputView.enter();
                break;
            }
            if (!move() && !retry()) {
                break;
            }
        }
    }

    private static boolean move() {
        String direction = inputView.readMoving();
        boolean isRightDirection = bridgeGame.move(direction);
        printBridge();

        return isRightDirection;
    }

    private static void printBridge() {
        List<String> upBridge = bridgeGame.getBridgeLine(UP);
        List<String> downBridge = bridgeGame.getBridgeLine(DOWN);

        outputView.printMap(upBridge);
        outputView.printMap(downBridge);
    }

    private static boolean retry() {
        String select = inputView.readGameCommand();
        return bridgeGame.retry(select);
    }

    private static void printGameResult() {
        outputView.printEnding();
        printBridge();
        String result = bridgeGame.getGameResult();
        int tryNum = bridgeGame.getTryNum();
        outputView.printResult(result, tryNum);
    }

}
