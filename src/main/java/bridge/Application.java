package bridge;

import dto.BridgeGameDto;
import view.InputView;
import view.OutputView;

public class Application {
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();
    static BridgeGame bridgeGame = new BridgeGame();
    static Result totalResult = new Result();

    public static void failGame(Bridge bridge) {
        String command;
        bridgeGame.initializeValues();
        OutputView.afterFail = true;
        do {
            outputView.printRestart();
            command = inputView.readGameCommand();
            if (!InputView.commandFormatError) {
                bridgeGame.retry(bridge, command);
            }
        } while (InputView.commandFormatError || bridgeGame.valueError);
    }

    public static void endGame(Bridge bridge, Boolean successGame) {
        outputView.printResult(bridge.sendDto(), totalResult.sendDto());
        BridgeGameDto bridgeGameDto = bridgeGame.sendDto();
        outputView.printReport(successGame, bridgeGameDto.totalTrial);
    }

    public static boolean judgeMove(Bridge bridge) {
        Boolean guessResult = bridge.isCorrectGuess(bridgeGame.sendDto());
        totalResult.update(guessResult);
        return guessResult;
    }

    public static void makeMove() {
        String direction;
        do {
            outputView.printEnterMove();
            direction = inputView.readMoving();
            if (!InputView.moveFormatError) {
                bridgeGame.move(direction);
            }
        } while (InputView.moveFormatError || bridgeGame.valueError);
    }

    public static boolean runGuessLoop(Bridge bridge) {
        boolean currentGuess = true;
        for (int currentPosition = 0; currentPosition < bridge.size() && currentGuess; currentPosition++) {
            BridgeGameDto bridgeGameDto = bridgeGame.sendDto();
            makeMove();
            currentGuess = judgeMove(bridge);
            outputView.printMap(bridge.sendDto(), totalResult.sendDto());
        }
        return currentGuess;
    }

    public static void launchGame(Bridge bridge) {
        Boolean successGame = runGuessLoop(bridge);
        if (!successGame) {
            failGame(bridge);
            return;
        }
        endGame(bridge, successGame);
    }

    public static Bridge buildBridgeBody() {
        Bridge bridge = null;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        do {
            outputView.printEnterBridgeSize();
            int bridgeSize = inputView.readBridgeSize();
            if (!InputView.sizeFormatError) {
                bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
            }
        } while (InputView.sizeFormatError || bridgeMaker.valueError);
        return bridge;
    }

    public static Bridge buildBridge() {
        outputView.printStart();
        Bridge bridge = buildBridgeBody();
        return bridge;
    }

    public static void main(String[] args) {
        try {
            Bridge bridge = buildBridge();
            launchGame(bridge);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }
}
