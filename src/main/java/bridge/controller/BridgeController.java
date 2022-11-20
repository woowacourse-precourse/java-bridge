package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeSize;
import bridge.domain.UserBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    public BridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public void start() {
        outputView.printStart();

        List<String> bridge = bridgeGame.setBridge(inputBridgeSize().getBridgeSize());
        startRound(bridge);
    }

    public BridgeSize inputBridgeSize() {
        try {
            return new BridgeSize(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return inputBridgeSize();
        }
    }

    private void startRound(List<String> bridge) {
        for (String answer : bridge) {
            String userSpace = inputBridgeSpace().getUserInput();
            List<String> map = bridgeGame.move(userSpace, answer);
            // 출력
            if (!isSameWithAnswer(userSpace, answer)) {
                //askRestart();
                break;
            }
        }
    }

    private UserBridge inputBridgeSpace() {
        try {
            return new UserBridge(inputView.readMoving());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return inputBridgeSpace();
        }
    }

    private boolean isSameWithAnswer(String user, String answer) {
        return user.equals(answer);
    }
}
