package bridge;

import constants.GameCommand;
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
        do{
            numberOfTimes += 1;
            bridgeGame.retry();
            index = oneTime();
            if (isSuccess(index)) {
                break;
            }
        }while(isRetry());
        end(isSuccess(index));
    }

    public void end(boolean result) {
        outputView.printEnd();
        outputView.printBridge(bridgeGame);
        outputView.printResult(result, numberOfTimes);
    }

    public int oneTime() {
        int index;
        for (index = 0; index < bridgeSize; index++) {
            boolean isMove = bridgeGame.move(bridge.get(index), choice());
            outputView.printBridge(bridgeGame);
            if (!isMove) {
                break;
            }
        }
        return index;
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
        return false;
    }
}
