package bridge.controller;

import static bridge.controller.InputController.setBridgeSize;
import static bridge.model.FinalResult.isFinalSuccess;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class GameController {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();

    public void play() {

        outputView.printStartGame();
        outputView.printBridgeSizeInput();

        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        // 다리 길이 입력해 다리 만들기
        List<String> createdBridge = bridgeMaker.makeBridge(setBridgeSize());

        Bridge bridge = new Bridge(createdBridge);

        // 다리 게임
        BridgeGame bridgegame = new BridgeGame(bridge);

        bridgegame.move();
        System.out.println(isFinalSuccess());


    }

}
