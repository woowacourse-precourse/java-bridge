package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.Application.move_Status;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(String bridge, String currentMoving) {
        List<String> movement = new ArrayList<>();
        if(currentMoving.equals("U")){
            movement.add(setMove(bridge, currentMoving));
            movement.add(" ");
            return movement;
        }
        movement.add(" ");
        movement.add(setMove(bridge, currentMoving));
        return movement;
    }

    public String setMove(String bridge, String currentMoving){
        if(!bridge.equals(currentMoving)) {
            move_Status = false;
            return "X";
        }
        return "O";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
