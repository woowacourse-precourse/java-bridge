package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Command;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private OutputView outputView;
    private InputView inputView;
    private BridgeGame bridgeGame;

    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }

    public void startController() {
        outputView.printStart();
    }

    public void setBridgeController() {
        try {
            final String input = inputView.readBridgeSize();
            bridgeGame.setBridge(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            setBridgeController();
        }
    }

    public void moveController() {
        try {
            final String move = inputView.readMoving();
            final List<String> bridge = bridgeGame.move(move);
            outputView.printMap(bridge);
            subMoveController(bridgeGame.getUserState());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            moveController();
        }
    }

    private void subMoveController(String userState) {
        if (userState.equals("실패")) {
            retry();
        } else if (userState.equals("진행중")) {
            moveController();
        } else if (userState.equals("성공")) {
            outputView.printResult(bridgeGame.getBridgeState(), bridgeGame.getTryTime(), userState);
        }
    }

    private void retry() {
        try {
            final String command = new Command(inputView.readGameCommand()).getCommand();
            subRetry(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            retry();
        }
    }

    private void subRetry(String command) {
        if (command.equals("R")) {
            bridgeGame.retry();
            moveController();
        } else if (command.equals("Q")) {
            outputView.printResult(bridgeGame.getBridgeState(), bridgeGame.getTryTime(), bridgeGame.getUserState());
        }
    }
}
