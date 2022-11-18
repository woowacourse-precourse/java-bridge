package bridge.controller;

import static bridge.UpDownBridge.downBridge;
import static bridge.UpDownBridge.upBridge;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.InputView;
import bridge.Message;
import bridge.OutputView;
import bridge.UpDownBridge;
import java.util.List;

public class BridgeGameController {

    private static boolean status = true;
    private static int bridgeLocation = 0;
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void  start() {
        int inputSize = inputView.inputBridgeSize();
        List<String> bridges = bridgeMaker.makeBridge(inputSize);
        System.out.println(bridges);
        while (status && bridgeLocation < inputSize) {
            String inputDirection = inputView.inputMovingDirection();
            String moveResult = bridgeGame.move(bridges.get(bridgeLocation), inputDirection);
            outputView.printMap(inputDirection, moveResult);
            bridgeLocation++;
        }
        outputView.printResult(status);
    }
}
