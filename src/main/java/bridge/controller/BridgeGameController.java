package bridge.controller;

import bridge.service.BridgeGameService;
import bridge.service.BridgeService;
import bridge.validator.GameCommandValidator;
import bridge.validator.MovingDirectionValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.Queue;

public class BridgeGameController {
    private final static String RESTART_GAME = "R";

    private final BridgeGameService bridgeGameService = new BridgeGameService();
    private final BridgeService bridgeService = new BridgeService();

    public void generateBridgeGame() {
        OutputView.startGame();
        bridgeGameService.initBridgeGame();
    }

    private String getCrossingDirection() {
        try {
            String crossingDirection = InputView.readMoving();
            MovingDirectionValidator.validateDirection(crossingDirection);
            return crossingDirection;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getCrossingDirection();
        }
    }

    private void play() {
        for (int distance = 0; distance + 1 <= bridgeService.getBridgeSize(); distance++) {
            String crossingDirection = getCrossingDirection();
            boolean crossSuccess = bridgeService.isPassable(distance, crossingDirection);
            bridgeGameService.crossOneBlock(crossingDirection, crossSuccess);
            OutputView.printMap(bridgeGameService.getBridgeMap());
            if (!crossSuccess) {
                break;
            }
        }
    }

    private String getGameCommand() {
        String input = InputView.readGameCommand();
        try {
            GameCommandValidator.validateCommand(input);
            return input;
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return getGameCommand();
        }
    }

    private boolean retryGame() {
        if (getGameCommand().equals(RESTART_GAME)) {
            bridgeGameService.retryGame();
            return true;
        }
        return false;
    }

    private void printGameResult() {
        String finalMap = bridgeGameService.getBridgeMap();
        Queue<String> gameStatics = bridgeGameService.getGameStatics();
        OutputView.printResult(finalMap, gameStatics);
    }

    public void run() {
        do {
            play();
        } while (!bridgeGameService.getCrosseSuccess() && retryGame());
        printGameResult();
    }
}