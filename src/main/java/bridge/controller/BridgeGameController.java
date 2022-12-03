package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.User;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        bridgeGame = initBridgeGame();
    }

    private BridgeGame initBridgeGame() {
        outputView.printGameStart();
        Bridge bridge = makeBridge();
        return new BridgeGame(bridge, new User());
    }

    private Bridge makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        Integer bridgeSize = inputView.readBridgeSize();
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    public void startGame() {
        play();
        outputView.printResult(
                bridgeGame.getTryCount(),
                bridgeGame.getBridgeDirections(),
                bridgeGame.getUserMoveHistory()
        );
    }

    private void play() {
        Boolean isMoved;
        do {
            String direction = inputView.readMoving();
            isMoved = bridgeGame.move(direction);
            outputView.printMap(bridgeGame.getBridgeDirections(), bridgeGame.getUserMoveHistory());
            if (bridgeGame.isEnd()) {
                return;
            }
        } while (isMoved);
        retry();
    }

    private void retry() {
        String command = inputView.readGameCommand();
        if (bridgeGame.retry(command)) {
            play();
        }
    }

}
