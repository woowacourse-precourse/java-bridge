package bridge.game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.convertor.InputConvertor;
import bridge.resource.GameConstant;
import bridge.validation.BridgeMoveValidator;
import bridge.validation.BridgeSizeValidator;
import bridge.validation.RetryValidator;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final BridgeStatus STATUS = new BridgeStatus();
    private static final RetryValidator RETRY_VALIDATOR = new RetryValidator();
    private static final BridgeSizeValidator SIZE_VALIDATOR = new BridgeSizeValidator();
    private static final BridgeMoveValidator MOVE_VALIDATOR = new BridgeMoveValidator();
    private static String MOVE;
    private final List<String> bridge;

    public BridgeGame() {
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator())
                .makeBridge(
                        InputConvertor.inputParseNumber(
                                SIZE_VALIDATOR.sizeValidator()
                        )
                );
        clearMap();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move() {
        MOVE = MOVE_VALIDATOR.moveValidator();
        crossingSuccess();
        boolean checkGaming = crossingFailure();
        if (checkFinish()) {
            return false;
        }
        return checkGaming;
    }

    private boolean checkFinish() {
        STATUS.checkGameOver(bridge.size());
        if (STATUS.getClear()) {
            gameOver();
            return true;
        }
        return false;
    }

    private void crossingSuccess() { // 다리 건너기 성공
        if (compare()) {
            drawingBridge(GameConstant.SUCCESS);
        }
    }

    private boolean crossingFailure() { // 다리 건너기 실패
        if (!compare()) {
            drawingBridge(GameConstant.BAD);
            return confirmRetry();
        }
        plusCurrentLocation();
        return true;
    }

    private boolean confirmRetry() {
        String retry = RETRY_VALIDATOR.retryValidator();
        if (retry.equals(GameConstant.RE)) {
            retry();
            return true;
        }
        gameOver();
        return false;
    }

    private void drawingBridge(String division) { // 이동 경로에 맞게 현재 다리 상황을 그린다.
        STATUS.drawingBridge(MOVE, division);
        printBridgeStatus();
    }

    private void gameOver() {
        STATUS.checkGameOver(bridge.size());
        STATUS.printGameOver();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        clearCurrentLocation();
        plusRetryCount();
        clearMap();
    }

    public boolean compare() {
        return bridge.get(STATUS.getCurrentLocation()).equals(MOVE);
    }

    private void plusCurrentLocation() {
        STATUS.plusCurrentLocation();
    }

    private void plusRetryCount() {
        STATUS.plusRetryCount();
    }

    private void clearCurrentLocation() {
        STATUS.clearCurrentLocation();
    }

    private void clearMap() {
        STATUS.clearMap();
    }


    private void printBridgeStatus() { // 현 다리 상태 프린팅
        STATUS.printBridgeStatus();
    }
}
