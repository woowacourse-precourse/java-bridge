package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int gameCount;
    private List<String> bridgeAnswer;
    private int nowStep;
    private String nowMoving;

    public void startGameSetCount(){
        this.gameCount = 1;
        this.nowStep = 0;
    }
    public void setBridgeAnswer(List<String> bridgeAnswer){
        this.bridgeAnswer = bridgeAnswer;
    }
    public int getGameCount(){
        return this.gameCount;
    }
    public String getNowMoving(){
        return this.nowMoving;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(Boolean canSuccess) {
        List<String> tmpBridge = deepcopy(this.bridgeAnswer.subList(0,nowStep+1));
        if (canSuccess){
            this.nowStep += 1;
            return tmpBridge;
        }
        tmpBridge.set(nowStep,"F");
        return tmpBridge;
    }
    public List<String> deepcopy(List<String> original){
        List<String> newString = new ArrayList<>();
        for (String str : original){
            newString.add(str);
        }
        return newString;
    }
    public Boolean checkFinish(){
        if (this.nowStep == this.bridgeAnswer.size())
            return true;
        return false;
    }
    public Boolean checkCanSuccess(String moving){
        this.nowMoving = moving;
        if (this.bridgeAnswer.get(nowStep).equals(moving))
            return true;
        return false;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.nowStep = 0;
        this.gameCount += 1;
    }
}
