package bridge.service;

import bridge.view.BridgePainting;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int attemp = 1;
    private final BridgeInit bridgeInit;
    private final BridgePainting bridgePainting;
    private List<String> bridge;

    public BridgeGame(BridgeInit bridgeInit, BridgePainting bridgePainting){
        this.bridgeInit = bridgeInit;
        this.bridgePainting = bridgePainting;
    }

    public void gameInit(){
        bridge = bridgeInit.makeGame();
    }

    public List<String> getBridge(){
        return bridge;
    }

    public BridgeInit getBridgeInit(){
        return bridgeInit;
    }

    public BridgePainting getBridgePainting(){
        return bridgePainting;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(int nextIndex, String nextStep) {
        if(bridge.get(nextIndex).equals(nextStep)) return true;
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgePainting.init();
    }
}
