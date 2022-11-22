package bridge;

import java.util.ArrayList;
import java.util.Arrays;
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
    public List<List<String>> move(List<String> bridge, String direction, int cnt) {
        List<List<String>> result = new ArrayList<>();
        if(direction.equals("U")){
            result.add(cnt,moveUp(bridge,cnt));
        }
        if(direction.equals("D")){
            result.add(cnt,moveDown(bridge,cnt));
        }
        return result;
    }

    public List<String> moveUp(List<String> bridge, int cnt){
        List<String> result = new ArrayList<>();
        if(bridge.get(cnt).equals("U")){
            result = Arrays.asList("O", "");
        }
        if(bridge.get(cnt).equals("D")){
            result = Arrays.asList("", "X");
        }
        return result;
    }

    public List<String> moveDown(List<String> bridge, int cnt){
        List<String> result = new ArrayList<>();
        if(bridge.get(cnt).equals("U")){
            result = Arrays.asList("", "X");
        }
        if(bridge.get(cnt).equals("D")){
            result = Arrays.asList("O", "");
        }
        return result;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
