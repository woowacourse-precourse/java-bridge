package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;

import bridge.model.GeneratedBridge;
import bridge.model.PlayerBridge;
import bridge.model.PrintBridge;
import bridge.util.TypeConversionUtil;


import java.util.List;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private GeneratedBridge generatedBridge;
    private final PlayerBridge playerBridge = new PlayerBridge();
    private final PrintBridge printBridge = new PrintBridge();

    private boolean canMove;
    private int nextStepIndex;
    private boolean isGameSuccess;

    public void initGame() {
        nextStepIndex = 0;
        canMove = true;
        isGameSuccess = false;
    }

    public void generateBridge(String bridgeSize) {
        List<String> bridgeShape = bridgeMaker.makeBridge(TypeConversionUtil.StringToInt(bridgeSize));
        generatedBridge = new GeneratedBridge(bridgeShape);
    }


    public boolean canMoveAndGameNotFinished() {
        return canMove && (isGameSuccess == false);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String inputNextStep) {
        canMove = generatedBridge.canMoveNextStep(nextStepIndex, inputNextStep);
        playerBridge.moveNextStep(inputNextStep, canMove);
        nextStepIndex++;
    }

    public String getCurrentBridgeUpShape() {
        return printBridge.generatePrintUpShape(playerBridge.getUpShape());
    }

    public String getCurrentBridgeDownShape() {
        return printBridge.generatePrintDownShape(playerBridge.getDownShape());
    }

    public void judgeGameStatus(String inputBridgeSize) {
        if (nextStepIndex == (TypeConversionUtil.StringToInt(inputBridgeSize)) && canMove) {
            isGameSuccess = true;
        }
    }

    public boolean isGameSuccess() {
        return isGameSuccess == true;
    }

    public boolean isGameFailure() {
        return isGameSuccess == false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        initGame();
        playerBridge.initializeShape();
    }
}
