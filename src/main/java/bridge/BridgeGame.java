package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> userBridge;
    private List<String> answerBridge;

    public BridgeGame(int size){
        BridgeNumberGenerator bridgeNumberGenerator=new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker=new BridgeMaker(bridgeNumberGenerator);
        this.answerBridge=bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moving) {
        userBridge.add(moving);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        for(int index=0;index<userBridge.size();index++){
            userBridge.remove(index);
        }
    }

    public List<String> getUserBridge(){
        return userBridge;
    }

    public List<String> getAnswerBridge(){
        return answerBridge;
    }
}
