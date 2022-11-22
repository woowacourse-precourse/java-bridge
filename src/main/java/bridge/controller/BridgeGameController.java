package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.command.GameCommand;
import bridge.domain.BridgeGame;
import bridge.exception.InputException;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private BridgeGameService bridgeGameService;

    public void start() {
        OutputView.printStart();
        set();
        progress();
        end();
    }

    private void set() {
        try {
            int size = getSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            bridgeGameService = new BridgeGameService(new BridgeGame(bridgeMaker.makeBridge(size)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            set();
        }
    }

    private int getSize() {
        int size = InputException.convertToNumber(InputView.readBridgeSize());
        InputException.validateBridgeSize(size);
        return size;
    }

    private void progress() {
        while (bridgeGameService.success() && !bridgeGameService.isComplete()) {
            move();
            OutputView.printMap(bridgeGameService.getBridge(), bridgeGameService.getResult());
        }
        if (!bridgeGameService.isComplete()) retry();
    }

    private void move() {
        try {
            String command = getMovingCommand();
            bridgeGameService.startOneRound(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            move();
        }
    }

    private static String getMovingCommand() {
        String command = InputView.readMoving();
        InputException.validateMovingCommand(command);
        return command;
    }

    private void end() {
        OutputView.printResult(bridgeGameService, bridgeGameService.getNumberOfAttempts());
    }

    private void retry() {
        try {
            String command = getGameCommand();
            if (command.equals(GameCommand.Restart.get())) executeRetry();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            retry();
        }
    }

    private void executeRetry() {
        bridgeGameService.restart();
        progress();
    }

    private static String getGameCommand() {
        String command = InputView.readGameCommand();
        InputException.validateGameCommand(command);
        return command;
    }
}
