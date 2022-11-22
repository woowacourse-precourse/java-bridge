package bridge.game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.convertor.InputConvertor;
import bridge.resource.GameConstant;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final BridgeStatus STATUS = new BridgeStatus();
    private final List<String> bridge;
    private static String MOVE;

    public BridgeGame() {
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator())
                .makeBridge(
                        InputConvertor.inputParseNumber(
                                Player.requestInputSizeToValidation()
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
        MOVE = Player.requestInputMoveToValidation();
        crossingSuccess();
        boolean checkGaming = crossingFailure();
        if (checkFinish()) {
            return false;
        }
        return checkGaming;
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

    private void crossingSuccess() {
        if (compare()) {
            drawingBridge(GameConstant.GOOD);
        }
    }

    private boolean crossingFailure() {
        if (!compare()) {
            drawingBridge(GameConstant.BAD);
            return confirmRetry();
        }
        plusCurrentLocation();
        return true;
    }

    private boolean confirmRetry() {
        String retry = Player.requestInputRetryToValidation();
        if (retry.equals(GameConstant.RE)) {
            retry();
            return true;
        }
        gameOver();
        return false;
    }

    private boolean checkFinish() {
        STATUS.checkGameOver(bridge.size());
        if (STATUS.getClear()) {
            gameOver();
            return true;
        }
        return false;
    }

    private void drawingBridge(String division) {
        STATUS.drawingBridge(MOVE, division);
        printBridgeStatus();
    }

    private void gameOver() {
        STATUS.checkGameOver(bridge.size());
        STATUS.printGameOver();
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

    private void printBridgeStatus() {
        STATUS.printBridgeStatus();
    }
}
