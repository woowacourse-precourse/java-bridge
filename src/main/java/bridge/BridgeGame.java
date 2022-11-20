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
    public String move(String moving, List<String> up_bridge, List<String> down_bridge) {
        // 사용자가 이동할 칸 moving, 다리 index
        InputView input = new InputView();

        String result = "";

        if (moving.equals(BridgeMaker.bridge_info.get(BridgeMaker.bridge_index))){
            if (moving.equals("U")){
                result = "U";
            }
            if (moving.equals("D")){
                result = "D";
            }

        }
        if (!(moving.equals(BridgeMaker.bridge_info.get(BridgeMaker.bridge_index)))){
            if (moving.equals("U")){
                result = "UX";
            }
            if (moving.equals("D")){
                result = "DX";
            }
        }
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(List<String> up_bridge, List<String> down_bridge) {
        BridgeMaker.bridge_index = 0;
        try_count++;
        up_bridge.clear();
        down_bridge.clear();

    }
}
