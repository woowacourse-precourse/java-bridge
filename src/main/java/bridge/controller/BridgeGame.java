package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.GeneratedBridge;
import bridge.model.PlayerBridge;
import bridge.model.PrintBridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
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

    public void printBridgeGameStartMessage() {
        outputView.printBridgeGameStartMessage();
    }

    public void initGame() {
        nextStepIndex = 0;
        canMove = true;
        isGameSuccess = false;
    }

    public void inputBridgeSize() {
        outputView.printInputBridgeSizeMessage();
        bridgeSize = inputView.inputBridgeSize();
    }

    public void generateBridge() {
        List<String> bridgeShape = bridgeMaker.makeBridge(Integer.parseInt(bridgeSize));
        generatedBridge = new GeneratedBridge(bridgeShape);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        outputView.printInputMovingStepMessage();
        inputNextStep = inputView.inputMovingStep();
        canMove = generatedBridge.canMoveNextStep(nextStepIndex, inputNextStep);
        playerBridge.moveNextStep(inputNextStep, canMove);
    }

    public void printCurrentBridge() {
        currentPlayerBridgeUpShape = printBridge.generatePrintUpShape(playerBridge.getUpShape());
        currentPlayerBridgeDownShape= printBridge.generatePrintDownShape(playerBridge.getDownShape());
        outputView.printMap(currentPlayerBridgeUpShape, currentPlayerBridgeDownShape);

    }

    public void judgeGameStatus() {
        if (nextStepIndex == Integer.parseInt(bridgeSize) -1 && canMove) {
            isGameSuccess = true;
        }
    }

    public void inputRetryOrEndCommand() {
        outputView.printRetryOrEndMessage();
        retryOrEndCommand = inputView.inputRetryOrEndCommand();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
