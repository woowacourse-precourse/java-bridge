package bridge;

import constants.GameCommand;
import constants.Symbol;
import java.util.List;

public class GameController {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame = new BridgeGame();

    private int bridgeSize;
    private int numberOfTimes = 0;
    private List<String> bridge;

    public void start() {
        outputView.printStart();
        outputView.printBridgeSize();
        bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
    }

    public void play() {
        int index;
        while (true) {
            numberOfTimes += 1;
            bridgeGame.retry();
            index = oneTime();
            if (isSuccess(index)) {
                break;
            }
            if (!isRetry()) {
                break;
            }
        }
        end(isSuccess(index));
    }

    public String toString(List<String> currentBridge) {
        String result = String.join(Symbol.SPLIT.getSymbol(), currentBridge);
        return result;
    }

    public void end(boolean result) {
        outputView.printEnd();
        outputView.printMap(toString(bridgeGame.getUpBridge()));
        outputView.printMap(toString(bridgeGame.getDownBridge()));
        outputView.printResult(result, numberOfTimes);
    }

    public int oneTime() {
        boolean isMove;
        int i;
        for (i = 0; i < bridgeSize; i++) {
            isMove = bridgeGame.move(bridge.get(i), choice());
            outputView.printMap(toString(bridgeGame.getUpBridge()));
            outputView.printMap(toString(bridgeGame.getDownBridge()));
            if (!isMove) {
                break;
            }
        }
        return i;
    }

    public String choice() {
        String moving;
        outputView.printMoving();
        moving = inputView.readMoving();
        return moving;
    }

    public boolean isSuccess(int number) {
        if (number == bridgeSize) {
            return true;
        }
        return false;
    }

    public boolean isRetry() {
        String gameCommand;
        outputView.printGameCommand();
        gameCommand = inputView.readGameCommand();
        if (gameCommand.equals(GameCommand.RESTART.getGameCommand())) {
            return true;
        }
        if (gameCommand.equals(GameCommand.END.getGameCommand())) {
            return false;
        }
        // TODO: 예외처리
        return false;
    }
}
