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
        bridgeGame.initializeValues();
        outputView.printRestart();
        String command = inputView.readGameCommand();
        bridgeGame.retry(bridge, command);
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

    public static void makeMove(int trial) {
        outputView.printEnterMove(trial);
        String direction = inputView.readMoving();
        bridgeGame.move(direction);
    }

    public static boolean runGuessLoop(Bridge bridge) {
        boolean currentGuess = true;
        for (int currentPosition = 0; currentPosition < bridge.size() && currentGuess; currentPosition++) {
            BridgeGameDto bridgeGameDto = bridgeGame.sendDto();
            makeMove(bridgeGameDto.totalTrial);
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

    public static Bridge buildBridge() {
        outputView.printStart();
        outputView.printEnterBridgeSize();
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
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
