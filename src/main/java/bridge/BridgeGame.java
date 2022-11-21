package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final List<String> up_bridge = new ArrayList<>();
    private static final List<String> down_bridge = new ArrayList<>();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean move(List<String> bridge, String updown, int count) {
        if(updown.contains(bridge.get(count))){
            add_bridge(updown, "O");
            return true;
        }

        add_bridge(updown, "X");
        return false;
    }
    public static void add_bridge(String updown, String OX){
        if (updown.contains("U")) {
            up_bridge.add(OX);
            down_bridge.add(" ");
        } else {
            down_bridge.add(OX);
            up_bridge.add(" ");
        }
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void retry() {
        up_bridge.clear();
        down_bridge.clear();
    }
    public static List<String> getUp_bridge(){
        return up_bridge;
    }
    public static List<String> getDown_bridge(){
        return down_bridge;
    }
}
