package bridge.controller;

import bridge.model.BridgeGame;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.BridgeMaker;
import bridge.model.BridgeMoveLog;
import bridge.model.BridgeType;
import bridge.model.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameController {

    private final OutputView outputView = new OutputView();

    private final InputView inputView = new InputView();

    private final ExceptionHandle exceptionHandle = new ExceptionHandle(outputView);

    private final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public void startGame() {
        outputView.printGameStart();
        List<String> bridge = createBridge();
    }

    private List<String> createBridge() {
        return exceptionHandle.getCorrectInput(() -> {
            outputView.printRequestBridgeLength();
            int bridgeSize = inputView.readBridgeSize();
            return bridgeMaker.makeBridge(bridgeSize);
        });
    }

    private BridgeType choiceBridge() {
        return exceptionHandle.getCorrectInput(() -> {
            outputView.printRequestMoveBridge();
            return inputView.readMoving();
        });
    }

}
