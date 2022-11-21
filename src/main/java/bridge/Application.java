package bridge;

import bridge.inputview.InputView;
import bridge.outputview.OutputView;
import java.util.List;

public class Application {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView = new InputView();
        outputView = new OutputView();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(inputView, outputView, bridge);
    }

    public static void main(String[] args) {
        (new Application()).run();
    }

    private void run() {
        int retryCount = 1;
        while (!bridgeGame.isSuccess()) {
            move();
            if (!isRetry()) {
                break;
            }
            retryCount++;
        }
        printResult(retryCount);
    }

    private void move() {
        boolean isMove = true;
        while (isStillPlayGame(isMove)) {
            String moving = inputView.readMoving();
            isMove = bridgeGame.isMove(moving);
            bridgeGame.move(moving);
            printCurrentBoard();
        }
    }

    private boolean isStillPlayGame(boolean isMove) {
        System.out.println(isMove + " " + bridgeGame.isSuccess());
        return isMove && !bridgeGame.isSuccess();
    }

    private void printCurrentBoard() {
        List<List<String>> map = bridgeGame.getMap();
        outputView.printMap(map);
    }

    private boolean isRetry() {
        if (bridgeGame.isSuccess()) {
            return false;
        }
        String inputGameCommand = inputView.readGameCommand();
        return bridgeGame.retry(inputGameCommand);
    }

    private void printResult(int retryCount) {
        List<List<String>> map = bridgeGame.getMap();
        String result = bridgeGame.getSuccess();
        outputView.printResult(map, result, retryCount);
    }

}
