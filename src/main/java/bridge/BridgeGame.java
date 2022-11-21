package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스 필드(인스턴스 변수)를 추가할 수 "있다".
 * 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 "있다".
 * BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final BridgePlay bridgePlay;
    private List<String> bridge;
    private int currentPosition = -1;
    private int totalTryCount = 1;
    private boolean success = true;
    private boolean complete = false;

    public BridgeGame() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgePlay = new BridgePlay();
    }

    public void requestBridge() {
        int bridgeSize = bridgeMaker.requestReadBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        // System.out.println(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        currentPosition++;
        String moveCommand = bridgePlay.requestReadMoving();
        if(!bridge.get(currentPosition).equals(moveCommand)) {
            success = false;
            return;
        }
        if(currentPosition == bridge.size()-1) {
            complete = true;
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry() {
        if(bridgePlay.requestReadRetry().equals("R")) {
            currentPosition = -1;
            success = true;
            totalTryCount++;
            return true;
        }
        return false;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public int getTotalTryCount() {
        return totalTryCount;
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isComplete() {
        return complete;
    }
}
