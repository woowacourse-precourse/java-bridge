package bridge.controller;

import bridge.service.BridgeGame;
import bridge.dto.BridgeRouteDto;
import bridge.dto.ResultDto;
import bridge.type.CommandType;
import bridge.validation.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {

    private final InputView inputView;

    private final OutputView outputView;

    private final BridgeGame bridgeGame;

    private final Validator validator;

    public BridgeController(InputView inputView, OutputView outputView, BridgeGame bridgeGame, Validator validator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeGame = bridgeGame;
        this.validator = validator;
    }
    public void run() {
        printStartMessage();
        makeBridge();
        moveToEndPoint();
        printResult();
    }

    private void printStartMessage() {
        outputView.printGreetingMessage();
    }

    private void makeBridge() {
        int bridgeSize = getBridgeSize();
        bridgeGame.makeBridge(bridgeSize);
    }

    private int getBridgeSize() {
        while (true) {
            String input = inputView.readBridgeSize();
            try {
                validator.checkBridgeSize(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
                continue;
            }
            return Integer.parseInt(input);
        }
    }

    private void moveToEndPoint() {
        while (true) {
            movePlayer();
            if (checkPlayerStatus()) {
                break;
            }
        }
    }

    private void movePlayer() {
        String direction = getDirection();
        bridgeGame.move(direction);
        BridgeRouteDto bridgeRouteDto = bridgeGame.getBridgeRouteDto();
        outputView.printMap(bridgeRouteDto);
    }

    private String getDirection() {
        while (true) {
            String input = inputView.readMoving();
            try {
                validator.checkDirection(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
                continue;
            }
            return input;
        }
    }

    private boolean checkPlayerStatus() {
        if (isPlayerFailToMove()) {
            if (isPlayerWantedToEnd()) {
                return true;
            }
        }
        if (isPlayerCompleteToMove()) {
            return true;
        }
        return false;
    }

    private boolean isPlayerFailToMove() {
        return bridgeGame.isPlayerFailToMove();
    }

    private boolean isPlayerWantedToEnd() {
        String input = getCommand();
        if (input.equals(CommandType.QUIT.getCommand())) {
            return true;
        }
        bridgeGame.retry();
        return false;
    }

    private String getCommand() {
        while (true) {
            String input = inputView.readGameCommand();
            try {
                validator.checkCommand(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
                continue;
            }
            return input;
        }
    }

    private boolean isPlayerCompleteToMove() {
        return bridgeGame.isPlayerCompleteToMove();
    }

    private void printResult() {
        ResultDto resultDto = bridgeGame.getResultDto();
        outputView.printResult(resultDto);
    }
}
