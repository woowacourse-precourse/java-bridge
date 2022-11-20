package bridge.controller;

import bridge.enums.GameCommand;
import bridge.service.BridgeGame;
import bridge.service.BridgeGameValidateService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final int TRY_COUNT_INIT_VALUE = 1;
    private static final String GAME_RESULT_SUCCESS = "성공";
    private static final String GAME_RESULT_FAILURE = "실패";

    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeGameValidateService bridgeGameValidateService = new BridgeGameValidateService();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private String inputBridgeSize;
    private String inputNextStep;
    private String gameRetryOrEndCommand;
    private String gameResult;
    private int tryCount = TRY_COUNT_INIT_VALUE;

    public void playGame() {
        initGame();
        printBridgeGameStartMessage();
        inputBridgeSize();
        generateBridge();
        moveUntilSuccessOrFailure();
        gameSuccessOrRetryOrEnd();
    }

    private void initGame() {
        bridgeGame.initGame();
    }

    private void printBridgeGameStartMessage() {
        outputView.printBridgeGameStartMessage();
    }

    private void inputBridgeSize() {
        while (true) {
            try {
                outputView.printInputBridgeSizeMessage();
                inputBridgeSize = inputView.inputBridgeSize();
                bridgeGameValidateService.validateInputBridgeSize(inputBridgeSize);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void generateBridge() {
        bridgeGame.generateBridge(inputBridgeSize);
    }

    private void moveUntilSuccessOrFailure() {
        while (bridgeGame.canMoveAndGameNotFinished()) {
            inputNextStep();
            bridgeGame.move(inputNextStep);
            printCurrentBridge();
            bridgeGame.judgeGameStatus(inputBridgeSize);
        }
    }

    public void inputNextStep() {
        while (true) {
            try {
                outputView.printInputMovingStepMessage();
                inputNextStep = inputView.inputMovingStep();
                bridgeGameValidateService.validateInputNextStep(inputNextStep);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printCurrentBridge() {
        String currentBridgeUpShape = bridgeGame.getCurrentBridgeUpShape();
        String currentBridgeDownShape = bridgeGame.getCurrentBridgeDownShape();

        outputView.printMap(currentBridgeUpShape, currentBridgeDownShape);
    }

    private void gameSuccessOrRetryOrEnd() {
        if (bridgeGame.isGameSuccess()) {
            gameResult = GAME_RESULT_SUCCESS;
            printGameResult();
        }
        if (bridgeGame.isGameFailure()) {
            gameResult = GAME_RESULT_FAILURE;
            retryOrEnd();
        }
    }

    public void printGameResult() {
        outputView.printGameResultMessage();
        printCurrentBridge();
        outputView.printResult(gameResult, tryCount);
    }

    private void retryOrEnd() {
        inputRetryOrEndCommand();
        if (gameRetryOrEndCommand.equals(GameCommand.RETRY.getCommand())) {
            tryCount++;
            bridgeGame.retry();
            moveUntilSuccessOrFailure();
            gameSuccessOrRetryOrEnd();
        }
        if (gameRetryOrEndCommand.equals(GameCommand.END.getCommand())) {
            printGameResult();
        }
    }

    public void inputRetryOrEndCommand() {
        while (true) {
            try {
                outputView.printRetryOrEndMessage();
                gameRetryOrEndCommand = inputView.inputRetryOrEndCommand();
                bridgeGameValidateService.validateGameRetryOrEndCommand(gameRetryOrEndCommand);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
