package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

    public BridgeGame start() {
        outputView.printStart();
        outputView.printGetLength();
        int BridgeLength = getBridgeLength();
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(BridgeLength));
        System.out.println(bridgeGame.getBridge());
        return bridgeGame;
    }

    public boolean play(BridgeGame bridgeGame) {
        if (bridgeGame.check()) {
            return false;
        }
        outputView.printGetMoving();
        String moving = getMoving();
        boolean movement = bridgeGame.move(moving);
        outputView.printMap(bridgeGame, movement);
        return movement;
    }

    public boolean finish(BridgeGame bridgeGame) {
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
