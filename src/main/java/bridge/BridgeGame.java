package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    public static List<String> bridgeU = new ArrayList<>();
    public static List<String> bridgeD = new ArrayList<>();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input, List<String> bridge, int index) {
        if (input.contains("U")) {
            user_Select_U(bridge, index);
        }
        if (input.contains("D")) {
            user_Select_D(bridge, index);
        }
    }

    private void user_Select_U(List<String> bridge, int index) {
        if (bridge.get(index) == "U") {
            bridgeU.add("O ");
            bridgeD.add(" ");
        }
        if (bridge.get(index) == "D") {
            bridgeU.add("X ");
            bridgeD.add(" ");
        }
    }

    private void user_Select_D(List<String> bridge, int index) {
        if (bridge.get(index) == "U") {
            bridgeU.add(" ");
            bridgeD.add("X ");
        }
        if (bridge.get(index) == "D") {
            bridgeU.add(" ");
            bridgeD.add("O ");
        }
    }

    public void clearBridge() {
        bridgeU.clear();
        bridgeD.clear();
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(Map<Integer, String> map) {
        if (map.get(0).contains("X") || map.get(1).contains("X")) {
            return false;
        }
        return true;
    }

    public boolean restartOrQuit(String input) {

        if (input.contains("R")) {
            return true;
        }
        if (input.contains("Q")) {
            return false;
        }
        return true;
    }


}
