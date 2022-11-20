package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeRandomNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    
    private List<String> bridgeList = new ArrayList<>();
    private List<String> bridgeStatus = new ArrayList<>();
    private boolean flag = false;
    private int count = 1;
    private int index = 0;
    private int size;

    /**
     * size의 Setter 메서드
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     * 사용자가 게임을 시작할 때 사용하는 메서드
     */
    public void makeBridgeGame(int size){
        setSize(size);
        bridgeList = bridgeMaker.makeBridge(this.size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     */
    public List<String> move(String input) {
        if (input.equals(bridgeList.get(index))){
            bridgeStatus.add(input + "O");
            index++;
            return bridgeStatus;
        }
        bridgeStatus.add(input + "X");
        index++;
        return bridgeStatus;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     */
    public void retry() {
        bridgeStatus.clear();
        count++;
    }
}
