package bridge.model;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private final int length;
    private final List<String> bridge;
    private boolean isDone = false;
    private int attemptCount = 1;
    private int playerFinalIndex;
    public BridgeGame(int length){
        this.length = length;
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(length);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String input,int bridgeIndex) {
        if(bridge.get(bridgeIndex).equals(input)){
            if(bridgeIndex == length-1)
                isDone = true;
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(String input,int index) {
        if(input.equals("R")) {
            this.attemptCount++;
            return -1;
        }
        setPlayerFinalIndex(index);
        return length+1;
    }

    public void setPlayerFinalIndex(int index){
        playerFinalIndex=index;
    }
    public int getPlayerFinalIndex(){
        return playerFinalIndex;
    }

    public int getLength(){
        return length;
    }

    public List<String> getBridge(){
        return bridge;
    }

    public boolean isDone(){
        return isDone;
    }
    public int getAttemptCount(){
        return attemptCount;
    }
}
