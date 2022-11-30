package bridge.Controller;

import bridge.Instances.EndType;
import bridge.Instances.InputType;
import bridge.View.InputView;
import bridge.View.OutputView;
import bridge.domain.BridgeGame;
import bridge.domain.Validation;

import java.util.List;

import static bridge.Instances.EndType.*;
import static bridge.Instances.EndType.FAIL_QUIT;

public class BridgeGameController {
    static InputView inputView;
    static OutputView outputView;
    BridgeGame bridgeGame;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
    }

    public BridgeGameController(BridgeGame bridgeGame) {
        inputView = new InputView();
        outputView = new OutputView();
        this.bridgeGame = bridgeGame;
    }


    public void start() {
        try {
            outputView.startGame();
            bridgeGame.setBridge(getBridgeSize());
            bridgeGame.initialize();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void moveUntilGameOver() {
        boolean correct;
        do {
            bridgeGame.move(getMoving());
            correct = bridgeGame.isLastMovingCorrect();
            printMoveResult(bridgeGame.bridge, bridgeGame.position, correct);
        } while (correct && !bridgeGame.gameSuccess());
    }

    public void printResult(boolean success) {
        printGameResult(bridgeGame.bridge, bridgeGame.position, success);
        printSuccessResult(success, bridgeGame.trial);
    }

    public EndType gameEnded() {
        if (bridgeGame.gameSuccess()) {
            return SUCCESS;
        }
        return bridgeGame.retry(getGameCommand());
    }

    public boolean printResultCheckRetry(EndType type) {
        if (type.equals(SUCCESS) || type.equals(FAIL_QUIT)) {
            printResult(type.getSuccess());
        }
        return type.getRetry();
    }

    public void playGame() {
        start();
        boolean retry;
        do {
            moveUntilGameOver();
            EndType type = gameEnded();
            retry = printResultCheckRetry(type);
        } while (retry);
    }

    private static String readInput(InputType type) {
        String input;
        while (true) {
            try {
                input = readAndValidateInput(type);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            return input;
        }
    }

    private static String readAndValidateInput(InputType type) {
        String input = inputView.read(type);
        Validation.validateInput(type, input);
        return input;
    }

    public static String getMoving() {
        return readInput(InputType.MOVING);
    }

    public static int getBridgeSize() {
        return Integer.parseInt(readInput(InputType.BRIDGE_SIZE));
    }

    public static String getGameCommand() {
        return readInput(InputType.GAME_COMMAND);
    }

    public static void printMoveResult(List<String> bridge, int position, boolean correct) {
        outputView.printMap(bridge, position, correct);
    }

    public static void printGameResult(List<String> bridge, int position, boolean success) {
        outputView.printResult(bridge, position, success);
    }

    public static void printSuccessResult(boolean success, int trial) {
        outputView.printSuccessOrFail(success, trial);
    }
}
