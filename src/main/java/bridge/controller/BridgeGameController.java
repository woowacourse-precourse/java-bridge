package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.vo.BridgeMap;
import bridge.domain.vo.BridgeSize;
import bridge.domain.vo.GameCommand;
import bridge.domain.vo.GameMoving;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        inputView.printStartBridgeGame();
        BridgeSize bridgeSize = inputBridgeSize();
        BridgeMap bridgeMap = makeBridgeMap(bridgeSize);
        GameCommand gameCommand = inputGameCommand();
    }

    private BridgeSize inputBridgeSize() {

        try {
            BridgeSize bridgeSize = new BridgeSize(inputView.readBridgeSize());
            return bridgeSize;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return inputBridgeSize();
    }

    private BridgeMap makeBridgeMap(BridgeSize bridgeSize) {
        System.out.println(bridgeSize.getValue());
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> test = bridgeMaker.makeBridge(bridgeSize.getValue());
        System.out.println(test);
        return new BridgeMap(test);
    }

    private GameMoving inputMoving() {
        try {
            GameMoving gameMoving = new GameMoving(inputView.readMoving());
            return gameMoving;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return inputMoving();
    }


    private GameCommand inputGameCommand() {
        try {
            GameCommand gameCommand = new GameCommand(inputView.readGameCommand());
            return gameCommand;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
        return inputGameCommand();
    }
}
