package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.ErrorConstant;
import bridge.model.GeneratedBridge;
import bridge.model.PlayerBridge;
import bridge.model.PrintBridge;
import bridge.validator.GameRetryOrEndCommandValidator;
import bridge.validator.InputBridgeSizeValidator;
import bridge.validator.InputNextStepValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String RETRY_COMMAND = "R";
    private static final String END_COMMAND = "Q";

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private GeneratedBridge generatedBridge;
    private final PlayerBridge playerBridge = new PlayerBridge();
    private final PrintBridge printBridge = new PrintBridge();

    private String bridgeSize;
    private boolean canMove;
    private int nextStepIndex;
    private String inputNextStep;
    private String currentPlayerBridgeUpShape;
    private String currentPlayerBridgeDownShape;
    private boolean isGameSuccess;
    private String retryOrEndCommand;
    private int tryCount = 1;
    private String successOrFailure;

    public void printBridgeGameStartMessage() {
        outputView.printBridgeGameStartMessage();
    }

    public void playGame() {
        initGame();
        printBridgeGameStartMessage();
        inputBridgeSize();
        generateBridge();
        moveUntilSuccessOrFailure();
        gameSuccessOrFailure();
    }

    public void initGame() {
        nextStepIndex = 0;
        canMove = true;
        isGameSuccess = false;
    }

    public void inputBridgeSize() {
        while (true) {
            try {
                outputView.printInputBridgeSizeMessage();
                bridgeSize = inputView.inputBridgeSize();
                inputBridgeSizeValidator.validate(bridgeSize);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void generateBridge() {
        List<String> bridgeShape = bridgeMaker.makeBridge(Integer.parseInt(bridgeSize));
        generatedBridge = new GeneratedBridge(bridgeShape);
    }

    private void moveUntilSuccessOrFailure() {
        while (canMove && (isGameSuccess == false)) {
            inputNextStep();
            move();
            printCurrentBridge();
            judgeGameStatus();
        }
    }

    public void inputNextStep() {
        while (true) {
            try {
                outputView.printInputMovingStepMessage();
                inputNextStep = inputView.inputMovingStep();
                inputNextStepValidator.validate(inputNextStep);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        canMove = generatedBridge.canMoveNextStep(nextStepIndex, inputNextStep);
        playerBridge.moveNextStep(inputNextStep, canMove);
        nextStepIndex++;
    }

    public void printCurrentBridge() {
        currentPlayerBridgeUpShape = printBridge.generatePrintUpShape(playerBridge.getUpShape());
        currentPlayerBridgeDownShape = printBridge.generatePrintDownShape(playerBridge.getDownShape());
        outputView.printMap(currentPlayerBridgeUpShape, currentPlayerBridgeDownShape);

    }

    public void judgeGameStatus() {
        if (nextStepIndex == Integer.parseInt(bridgeSize) && canMove) {
            isGameSuccess = true;
        }
    }

    private void retryOrEnd() {
        inputRetryOrEndCommand();
        if (retryOrEndCommand.equals(RETRY_COMMAND)) {
            tryCount++;
            playerBridge.initializeShape();
            retry();
        }
        if (retryOrEndCommand.equals(END_COMMAND)) {
            printGameResult();
        }
    }

    public void inputRetryOrEndCommand() {
        while (true) {
            try {
                outputView.printRetryOrEndMessage();
                retryOrEndCommand = inputView.inputRetryOrEndCommand();
                gameRetryOrEndCommandValidator.validate(retryOrEndCommand);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        initGame();
        moveUntilSuccessOrFailure();
        gameSuccessOrFailure();
    }

    private void gameSuccessOrFailure() {
        if (isGameSuccess) {
            successOrFailure = "성공";
            printGameResult();
        }
        if (isGameSuccess == false) {
            successOrFailure = "실패";
            retryOrEnd();
        }
    }

    public void printGameResult() {
        outputView.printGameResultMessage();
        outputView.printMap(currentPlayerBridgeUpShape, currentPlayerBridgeDownShape);
        outputView.printResult(successOrFailure, tryCount);
    }
}
