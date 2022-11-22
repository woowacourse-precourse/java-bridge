package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.BridgeLength;
import bridge.model.BridgeMoving;
import bridge.model.BridgeCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeGame bridgeGame;


    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void go() {
        int bridgeSize = start();
        do {
            if(bridgeGame.checkEndPoint()){
                break;
            }
            play();
            outputView.printMap(bridgeGame.getMap(), bridgeGame.getLocation());
        } while (retryGame(bridgeSize));
        end();
    }



    private int start() {
        outputView.printInit();
        BridgeLength bridgeLength = getBridgeLength();
        bridgeGame = BridgeGame.createBridgeGame(bridgeLength.getLength());
        return bridgeLength.getLength();
    }

    private BridgeLength getBridgeLength() {
        try {
            String size = inputView.readBridgeSize();
            BridgeLength bridgeLength = BridgeLength.createBridgeLength(size);
            return bridgeLength;
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return getBridgeLength();
        }
    }

    private void play() {
        String moving = getMoving();
        bridgeGame.move(moving);
    }

    private String getMoving() {
        try {
            String moving = inputView.readMoving();
            BridgeMoving.createBridgeMoving(moving);
            return moving;
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return getMoving();
        }
    }

    private boolean retryGame(int size) {
        boolean retry = true;
        if (bridgeGame.isFail()) {
            String command = getCommand();
            retry = isRetryOrClose(size, command);
        }
        return retry;
    }

    private String getCommand() {
        try {
            String command = inputView.readGameCommand();
            BridgeCommand bridgeCommand = BridgeCommand.createBridgeCommand(command);
            return command;
        } catch (IllegalArgumentException e) {
            outputView.printException(e.getMessage());
            return getCommand();
        }
    }

    private boolean isRetryOrClose(int size, String retryOrClose) {
        BridgeCommand bridgeCommand = BridgeCommand.createBridgeCommand(retryOrClose);
        if (bridgeCommand.getCommand()) {
            bridgeGame.retry(size);
            return true;
        }
        return false;
    }

    private void end() {
        outputView.printFinalMap(bridgeGame.getMap(), bridgeGame.getLocation());
        outputView.printResult(bridgeGame.getRetryCount(), !bridgeGame.isFail());
    }
}
