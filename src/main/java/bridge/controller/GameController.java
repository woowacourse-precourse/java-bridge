package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public void play() {
        BridgeGame bridgeGame = new BridgeGame();

        // 다리 생성
        outputView.printStartGame();
        List<String> bridge = setBridgeSize();
        System.out.println(bridge);

        // 다리 게임
        boolean success = bridgeGame.move(bridge.get(0), setMovingOption());
        System.out.println(success);
        bridge.remove(0);
        System.out.println(bridge);
        while (success) {
            success = bridgeGame.move(bridge.get(0), setMovingOption());
            System.out.println(success);
            System.out.println(bridge);
            bridge.remove(0);
        }

    }

    private List<String> setBridgeSize() {
        try {
            outputView.printBridgeSizeInput();
            BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
            return bridgeMaker.makeBridge(inputView.readBridgeSize());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            setBridgeSize();
        }
        return null;
    }

    private String setMovingOption() {
        try {
            outputView.printMoveInput();
            return inputView.readMoving();
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return setMovingOption();
        }
    }
}
