package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static List<String> bridgeList = new ArrayList<>();
    private final BridgeRandomNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    
    private List<String> bridgeStatus = new ArrayList<>();
    private boolean flag = false;
    private int count = 1;

    public BridgeGame(int size){
        bridgeList = bridgeMaker.makeBridge(size);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String input, int index) {
        String status = input;
        if (input.equals(bridgeList.get(index))){
            status += "O";
            bridgeStatus.add(status);
            return bridgeStatus;
        }
        status += "X";
        bridgeStatus.add(status);
        return bridgeStatus;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        bridgeStatus.clear();
        count++;
    }
}
