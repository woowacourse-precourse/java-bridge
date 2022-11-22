package bridge;

import static bridge.BridgeGame.O;

import java.util.ArrayDeque;
import java.util.Deque;

public class Controller {


    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private BridgeGame bridgeGame;
    private Deque<String> bridgeIndex;
    private int count;
    private boolean isSuccess;

    public Controller() {
        bridgeGame = new BridgeGame();
    }

    public void game() {
        inputView.printGameStart();
        bridgeGame.start(inputView.readBridgeSize());
        while (!crossingBridge() && bridgeGame.retry(inputView.readGameCommand())) {
        }
        outputView.printResult(isSuccess, count);
    }

    public boolean crossingBridge() {
        outputView.initMap();
        bridgeIndex = new ArrayDeque<>(bridgeGame.getBridge());
        count++;
        isSuccess = true;
        while (!bridgeIndex.isEmpty() && isSuccess) {
            String input = inputView.readMoving();
            String ox = bridgeGame.move(bridgeIndex.poll(), input);
            outputView.writeMap(inputView.isUP(), ox);
            outputView.printMap();
            isSuccess = ox.equals(O);
        }
        return isSuccess;
    }
}