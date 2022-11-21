package bridge.domain;

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

    public static void clear() {
        upBridge.clear();
        downBridge.clear();
    }

    public static boolean retry(String input) {
        if(input.equals("Q")) {
            return false;
        }
        return true;
    }
}
