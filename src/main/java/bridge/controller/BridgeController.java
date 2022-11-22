package bridge.controller;

import bridge.service.BridgeGame;
import bridge.model.BridgeSize;
import bridge.model.Command;
import bridge.model.UserBridge;
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
        startPlay(bridge);
        outputView.printResult(bridgeGame.getMap(), bridgeGame.getResult());
    }

    private BridgeSize inputBridgeSize() {
        try {
            return new BridgeSize(inputView.readBridgeSize());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return inputBridgeSize();
        }
    }

    private void startPlay(List<String> bridge) {
        do {
            bridgeGame.setRound();
            startRound(bridge);
        } while (askRestart(bridgeGame.isClear()));
    }

    private void startRound(List<String> bridge) {
        for (String answer : bridge) {
            String userDirection = inputDirection().getUserInput();
            outputView.printMap(goDirection(userDirection, answer));

            if (!isSameWithAnswer(userDirection, answer)) {
                bridgeGame.changeToFail();
                break;
            }
        }
    }

    private List<String> goDirection(String direction, String answer) {
        return bridgeGame.move(direction, answer);
    }

    private UserBridge inputDirection() {
        try {
            return new UserBridge(inputView.readMoving());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return inputDirection();
        }
    }

    private boolean isSameWithAnswer(String user, String answer) {
        return user.equals(answer);
    }

    private boolean askRestart(boolean success) {
        if (!success) {
            return bridgeGame.retry(inputCommand().getCommand());
        }
        return false;
    }

    private Command inputCommand() {
        try {
            return new Command(inputView.readGameCommand());
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return inputCommand();
        }
    }
}
