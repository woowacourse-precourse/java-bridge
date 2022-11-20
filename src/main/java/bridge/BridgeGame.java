package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static int try_count = 1;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(List<String> up_bridge, List<String> down_bridge) {
        // 사용자가 이동할 칸 moving, 다리 index
        InputView input = new InputView();
        String moving = input.readMoving();
        String result = "";

        if (moving.equals(BridgeMaker.bridge_info.get(BridgeMaker.bridge_index))){
            if (moving.equals("U")){
                up_bridge.add(" O ");
                down_bridge.add("   ");
            }
            if (moving.equals("D")){
                up_bridge.add("   ");
                down_bridge.add(" O ");
            }
            result = "O";
        }
        if (!(moving.equals(BridgeMaker.bridge_info.get(BridgeMaker.bridge_index)))){
            if (moving.equals("U")){
                up_bridge.add(" X ");
                down_bridge.add("   ");
            }
            if (moving.equals("D")){
                up_bridge.add("   ");
                down_bridge.add(" X ");
            }
            result = "X";
        }
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        BridgeMaker.bridge_index = 0;
        try_count++;
    }
}
