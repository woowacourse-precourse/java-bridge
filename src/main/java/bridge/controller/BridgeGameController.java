package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridgeGame.gameStatus.gameStatics.GameResult;
import bridge.exception.NotNumericException;
import bridge.service.BridgeGameService;
import bridge.service.BridgeMapService;
import bridge.utils.StringUtils;
import bridge.validator.BridgeSizeValidator;
import bridge.validator.GameCommandValidator;
import bridge.validator.MovingDirectionValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.Queue;

public class BridgeGameController {
    private final static String RESTART_GAME = "R";

    private final BridgeGameService bridgeGameService = BridgeGameService.getInstance();
    private final BridgeMapService bridgeMapService = BridgeMapService.getInstance();

    public List<String> generateBridge() {
        String input = InputView.readBridgeSize();

        try {
            return initBridge(input);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return generateBridge();
        }
    }

    private List<String> initBridge(String input) {
        if (!StringUtils.isNumeric(input)) {
            throw new NotNumericException();
        }
        int bridgeSize = Integer.parseInt(input);
        BridgeSizeValidator.validateBridgeSize(bridgeSize);

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public void generateBridgeGame() {
        OutputView.startGame();

        List<String> bridge = generateBridge();
        bridgeGameService.initBridgeGame(bridge);
        bridgeMapService.initMap();
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
            bridgeMapService.resetBridgeMap();
            return true;
        }
        return false;
    }

    private void printGameResult() {
        String finalMap = bridgeMapService.getBridgeMap();
        Queue<String> gameStatics = bridgeGameService.getGameStatics();
        OutputView.printResult(finalMap, gameStatics);
    }

    public void run() {
        GameResult gameResult = GameResult.NOT_EXIST;
        while (gameResult.equals(GameResult.NOT_EXIST) || gameResult.equals(GameResult.FAIL) && retryGame()) {
            String direction = getCrossingDirection();
            gameResult = bridgeGameService.move(direction);
            bridgeMapService.generateMap(direction, gameResult.crossSuccess());
            OutputView.printMap(bridgeMapService.getBridgeMap());
        }
        printGameResult();
    }
}