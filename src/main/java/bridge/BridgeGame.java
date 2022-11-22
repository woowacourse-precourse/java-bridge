package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */

public class BridgeGame {

    private Bridge bridge = new Bridge();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public boolean move(String bridgeMove, String moving) {
        if ((bridgeMove.equals(moving))) {
            return true;
        }
        return false;
    }

    // 다리 건너기의 결과에 따라 O 또는 X를 이용하여 출력할 다리를 생성
    public Bridge moveBridge(String bridgeMove, boolean isMove) {
        if (isMove) {
            successMoveBridge(bridgeMove);
            bridge.setOutputBridge(this.bridge.getOutputBridge());
            return bridge;
        }
        filaMoveBridge(bridgeMove);
        bridge.setOutputBridge(this.bridge.getOutputBridge());
        return bridge;
    }

    public void successMoveBridge(String bridgeMove) {
        if (bridgeMove.equals("U")) {
            successBridgeUp();
            return;
        }
        successBridgeDown();
    }

    public void filaMoveBridge(String bridgeMove) {
        if (bridgeMove.equals("U")) {
            failBridgeUp();
            return;
        }
        failBridgeDown();
    }

    public void successBridgeUp() {
        bridge.getOutputBridge().get(0).add(" O ");
        bridge.getOutputBridge().get(1).add("   ");
    }

    public void successBridgeDown() {
        bridge.getOutputBridge().get(0).add("   ");
        bridge.getOutputBridge().get(1).add(" O ");
    }

    public void failBridgeUp() {
        bridge.getOutputBridge().get(0).add("   ");
        bridge.getOutputBridge().get(1).add(" X ");
    }

    public void failBridgeDown() {
        bridge.getOutputBridge().get(0).add(" X ");
        bridge.getOutputBridge().get(1).add("   ");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameRetry) {
        if (gameRetry.equals("R")) {
            bridge.setTryCount(Bridge.getTryCount() + 1); // 시도 횟수 1 증가
            return true;
        }
        return false;
    }

}
