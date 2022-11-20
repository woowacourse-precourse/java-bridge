package bridge.domain;

import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    static List<String> upBridge = new ArrayList<>();
    static List<String> downBridge = new ArrayList<>();

    public static List<String> getUpBridge() {
        return upBridge;
    }

    public static List<String> getDownBridge() {
        return downBridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void move(List<String> bridge, int idx, String input) {
        up(bridge, idx, input);
        down(bridge, idx, input);
    }

    private static void up(List<String> bridge, int idx, String input) {
        if(!input.equals("U")) {
            upBridge.add(idx, " ");
            return;
        }
        if(bridge.get(idx).equals(input)) {
            upBridge.add(idx, "O");
            return;
        }
        upBridge.add(idx, "X");
    }

    private static void down(List<String> bridge, int idx, String input) {
        if(!input.equals("D")) {
            downBridge.add(idx, " ");
            return;
        }
        if(bridge.get(idx).equals(input)) {
            downBridge.add(idx, "O");
            return;
        }
        downBridge.add(idx, "X");
    }

    public static boolean isGameOver(List<String> bridge, int idx, String input) {
        if(!bridge.get(idx).equals(input)) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static boolean retry(String input) {
        if(input.equals("Q")) {
            return false;
        }
        upBridge.clear();
        downBridge.clear();
        return true;
    }
}
