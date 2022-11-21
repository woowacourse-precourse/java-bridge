package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static List<String> upBridge = new ArrayList<>();
    private static List<String> downBridge = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String moveEqualBridge(String bridge, String inputUpOrDown) {
        String movement = "";
        if(bridge.equals(inputUpOrDown)){
            movement = "O";
        }
        if(!bridge.equals(inputUpOrDown)){
            movement = "X";
        }
        return movement;
    }

    private void addSpacebar(String inputUpOrDown,String correct){
        if(inputUpOrDown.equals("U")){
            upBridge.add(" " + correct + " ");
            downBridge.add("   ");
        }
        if(inputUpOrDown.equals("D")){
            upBridge.add("   ");
            downBridge.add(" " + correct + " ");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
