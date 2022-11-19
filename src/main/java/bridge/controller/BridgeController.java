package bridge.controller;

import bridge.service.BridgeGame;
import bridge.dto.CurrentPositionDto;
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

    private void printResult() {
        ResultDto resultDto = bridgeGame.getResultDto();
        outputView.printResult(resultDto);
    }

    private void moveToEndPoint() {
        while (true) {
            movePlayer();
            if (checkPlayerStatus()) {
                break;
            }
        }
    }

    private boolean checkPlayerStatus() {
        if (FailToMove()) {
            if (isPlayerWantedToEnd()) {
                return true;
            }
        }
        if (CompleteToMove()) {
            return true;
        }
        return false;
    }

    private boolean CompleteToMove() {
        return bridgeGame.isPlayerCompleteToMove();
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

    private boolean FailToMove() {
        return bridgeGame.isPlayerFailToMove();
    }

    private void movePlayer() {
        String direction = getDirection();
        bridgeGame.move(direction);
        CurrentPositionDto currentPosition = bridgeGame.getCurrentPosition();
        outputView.printMap(currentPosition);
    }

    private void makeBridge() {
        int bridgeSize = getBridgeSize();
        bridgeGame.makeBridge(bridgeSize);
    }

    private String getDirection() {
        while (true) {
            String input = inputView.readMoving();
            try {
                validator.checkMoving(input);
            } catch (IllegalArgumentException e) {
                outputView.printError(e);
                continue;
            }
            return input;
        }
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

    private void printStartMessage() {
        outputView.printGreetingMessage();
    }
}
