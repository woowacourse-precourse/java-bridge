package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public BridgeGame start() {
        outputView.printStart();
        outputView.printGetLength();
        int BridgeLength = getBridgeLength();
        return new BridgeGame(bridgeMaker.makeBridge(BridgeLength));
    }

    public List<Boolean> movement(BridgeGame bridgeGame) {
        if (bridgeGame.check()) {
            return List.of(true, false);
        }
        outputView.printGetMoving();
        String moving = getMoving();
        boolean movement = bridgeGame.move(moving);
        outputView.printMap(bridgeGame, movement);
        return List.of(false, movement);
    }

    public boolean play(BridgeGame bridgeGame) {
        List<Boolean> result;
        do {
            do {
                result = movement(bridgeGame);
            } while (result.get(1));
            if (result.get(0)) {
                return true;
            }
        } while (finish(bridgeGame));
        return false;
    }

    private boolean finish(BridgeGame bridgeGame) {
        outputView.printRetry();
        String gameCommand = getCommand();
        return bridgeGame.retry(gameCommand);
    }

    public void result(BridgeGame bridgeGame, boolean success) {
        outputView.printResult(bridgeGame, success);
    }

    private int getBridgeLength() {
        int BridgeLength = inputView.readBridgeSize();
        while (BridgeLength == 0) {
            BridgeLength = inputView.readBridgeSize();
        }
        return BridgeLength;
    }

    private String getMoving() {
        String moving = inputView.readMoving();
        while (moving == null) {
            moving = inputView.readMoving();
        }
        return moving;
    }

    private String getCommand() {
        String gameCommand = inputView.readGameCommand();
        while (gameCommand == null) {
            gameCommand = inputView.readGameCommand();
        }
        return gameCommand;
    }

}
