package bridge;

import bridge.View.InputView;
import bridge.View.OutputView;
import bridge.domain.BridgeGame;

import java.util.Objects;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;
    private int tryCount;
    private String success;

    public Controller(InputView input, OutputView output, BridgeRandomNumberGenerator generator) {
        this.inputView = input;
        this.outputView = output;
        this.bridgeMaker = new BridgeMaker(generator);
        this.tryCount = 0;
        this.success = "실패";
    }

    public void startGame() {
        outputView.printGameStart();
        int bridgeSize = inputView.getReadBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize));
        tryGame(bridgeSize, bridgeGame);
        tryCount += 1;
        checkIsSuccess(bridgeGame.getIndex(), bridgeSize);
        outputView.printResult(bridgeGame, success, tryCount);
    }

    private void checkIsSuccess(int index, int bridgeSize) {
        if (index == bridgeSize) {
            success = "성공";
        }
    }

    private void tryGame(int bridgeSize, BridgeGame bridgeGame) {
        while (bridgeGame.getIndex() < bridgeSize && !bridgeGame.getIsQuit()) {
            String direction = inputView.getReadMoving();
            bridgeGame.move(direction);
            outputView.printMap(bridgeGame.getUpBridge(), bridgeGame.getDownBridge());
            if (!bridgeGame.isFailed()) continue;
            if (retryGame(bridgeGame)) break;
        }
    }

    private boolean retryGame(BridgeGame bridgeGame) {
        String command = inputView.readGameCommand();
        if (!isRetry(bridgeGame, command)) return true;
        bridgeGame.retry();
        return false;
    }

    private boolean isRetry(BridgeGame bridgeGame, String command) {
        if (Objects.equals(command, "R")) {
            bridgeGame.retry();
            tryCount += 1;
            return true;
        }
        return false;
    }

}
