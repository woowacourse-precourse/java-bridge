package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> choice = new ArrayList<String>();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String moving, List<String> bridge) {
        for(int i = 0; i < bridge.size(); i++) {
            if(moving.equals(bridge.get(i))) {
                this.choice.add("O");
            }
            if(!moving.equals(bridge.get(i))) {
                this.choice.add("X");
            }
        }
        return this.choice;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> choice) {
        for(int i = 0; i < this.choice.size(); i++) {
            if(this.choice.get(i).equals("X")) {
                break;
            }
        }
    }
}
