package bridge.service;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.enumtype.BridgeGameRule;
import bridge.constant.enumtype.UIMessage;
import bridge.dto.bridge.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class BridgeGameService {
    private InputView bridgeGameInputView;
    private OutputView bridgeGameOutputView;
    private Bridge bridge;
    private BridgeGame bridgeGame;
    private Boolean isPassedMoving;
    private List<String> movedBridge;
    private static String readRetryGameCommand = "";

    public BridgeGameService() {
        this.bridgeGameInputView = new InputView();
        this.bridgeGameOutputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    private Integer readBridgeSize() {
        try {
            return bridgeGameInputView.readBridgeSize();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readBridgeSize();
        }
    }

    public void createBridge() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(readBridgeSize());
        saveBridge(bridge);
    }

    private void saveBridge(List<String> bridge) {
        this.bridge = new Bridge(bridge);
    }

    private String readMoving() {
        try {
            return bridgeGameInputView.readMoving();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readMoving();
        }
    }

    private String readGameCommand() {
        try {
            return bridgeGameInputView.readGameCommand();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readGameCommand();
        }
    }

    public Boolean moveBridge() {
        this.movedBridge = bridgeGame.move(bridge.getBridge(), readMoving());
        bridgeGameOutputView.printMap(bridge.getBridge(), movedBridge);
        isPassedMoving = !(movedBridge.contains(UIMessage.INFO_BRIDGE_MOVE_FAILED.getValue()));
        if (isPassedMoving && bridge.getBridge().size() != movedBridge.size()) {
            moveBridge();
        }
        return isPassedMoving;
    }

    public void bridgeGameRetry() {
        if (bridgeGame.retry(readGameCommand())) {
            moveBridge();
        }
    }

    public void printResult() {
        bridgeGameOutputView.printResult(bridge.getBridge(), movedBridge, isPassedMoving);
    }
}
