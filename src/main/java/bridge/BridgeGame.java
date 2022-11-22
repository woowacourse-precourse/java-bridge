package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<Integer> move(List<String> bridge, List<Integer> position_map, String moving) {
        int position = Arrays.asList(position_map).indexOf(1);  //i 번째에 1의 값이 있으면 i번째 칸에 위치, 0이면 출발안함
        if(moving.equals(bridge.get(position))) {
            position_map.set(position,0);
            position_map.set(position+1,1);
        }
        if(!moving.equals(bridge.get(position))) {
            position_map.set(position,0);
            position_map.set(0,1);
        }
        return position_map;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<Integer> retry(List<Integer> position_map, String input) {
        if(input.equals("R")) {
            Collections.replaceAll(position_map,1,0);
            position_map.set(0,1);
        }
        if(input.equals("Q")) {
            Collections.replaceAll(position_map,1,0);
        }
        return position_map;
    }
}
