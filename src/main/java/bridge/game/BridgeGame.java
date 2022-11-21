package bridge.game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.convertor.InputConvertor;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final Function function = new Function();
    private final BridgeStatus status = new BridgeStatus();
    private static String MOVE;

    public BridgeGame() {
        bridge = new BridgeMaker(new BridgeRandomNumberGenerator())
                .makeBridge(
                        InputConvertor.inputParseNumber(
                                function.sizeValidation()
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
        MOVE = function.moveValidation();
        crossingSuccess();
        boolean b = crossingFailure();
        if (checkFinish()) {
            return false;
        }
        return b;
    }

    private boolean checkFinish() {
        status.checkGameOver(bridge.size());
        if (status.getClear()) {
            gameOver();
            return true;
        }
        return false;
    }

    private void crossingSuccess() { // 다리 건너기 성공
        if (compare(MOVE)) {
            drawingBridge("O");
        }
    }

    private boolean crossingFailure() { // 다리 건너기 실패
        if (!compare(MOVE)) {
            drawingBridge("X");
            return confirmRetry();
        }
        plusCurrentLocation();
        return true;
    }

    private boolean confirmRetry() {
        String retry = function.retryValidation();
        if (retry.equals("R")) {
            retry();
            return true;
        }
        gameOver();
        return false;
    }

    private void drawingBridge(String division) { // 이동 경로에 맞게 현재 다리 상황을 그린다.
        status.drawingBridge(MOVE, division);
        printBridgeStatus();
    }


    private void gameOver() {
        status.checkGameOver(bridge.size());
        status.printGameOver();

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


    public boolean compare(String move) {
        return bridge.get(status.getCurrentLocation()).equals(move);
    }

    private void plusCurrentLocation() { // 상태 업데이트
        status.plusCurrentLocation();
    }

    private void plusRetryCount() { //  // 상태 업데이트
        status.plusRetryCount();
    }

    private void clearCurrentLocation() { // retry 관련
        status.clearCurrentLocation();
    }
    // retry 관련

    private void clearMap() { // retry 관련
        status.clearMap();
    }


    private void printBridgeStatus() { // 현 다리 상태 프린팅
        status.printBridgeStatus();
    }
}
