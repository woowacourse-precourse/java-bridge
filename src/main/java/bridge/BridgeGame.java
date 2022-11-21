package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public static final String UP = "U";
    public static final String DOWN = "D";
    public static final String RIGHT = "O ";
    public static final String WRONG = "X ";
    public static final String SPACE_BRIDGE = "  ";

    public static final String RESTART = "R";
    public static final String QUIT = "Q";

    static List<String> upstairsBridge = new ArrayList<>();
    static List<String> downstairsBridge = new ArrayList<>();
    static List<String> triedAnswers = new ArrayList<>();

    public List<String> upstairsBridge () {
        return upstairsBridge;
    }
    public List<String> downstairsBridge () {
        return downstairsBridge;
    }

    public List<String> getUpstairsBridge (String direction, List<String> bridge, int numberOfTrying) {
        int eachBridge = numberOfTrying - 1;
        if (Objects.equals(direction, DOWN)) {
            upstairsBridge.add(eachBridge, SPACE_BRIDGE);
        }
        if (Objects.equals(direction, bridge.get(eachBridge)) && Objects.equals(direction, UP)) {
            upstairsBridge.add(eachBridge, RIGHT);
        }
        if (!Objects.equals(direction, bridge.get(eachBridge)) && Objects.equals(direction, UP)) {
            upstairsBridge.add(eachBridge, WRONG);
        }
        return upstairsBridge;
    }

    public List<String> getDownstairsBridge (String direction, List<String> bridge, int numberOfTrying) {
        int eachBridge = numberOfTrying - 1;

        if (Objects.equals(direction, UP)) {
            downstairsBridge.add(eachBridge, SPACE_BRIDGE);
        }
        if (Objects.equals(direction, bridge.get(eachBridge)) && Objects.equals(direction, DOWN)) {
            downstairsBridge.add(eachBridge, RIGHT);
        }
        if (!Objects.equals(direction, bridge.get(eachBridge))&& Objects.equals(direction, DOWN)) {
            downstairsBridge.add(eachBridge, WRONG);
        }
        return downstairsBridge;
    }

    public void move(String direction, List<String> bridge, int numberOfTrying) {
        getUpstairsBridge(direction, bridge, numberOfTrying);
        getDownstairsBridge(direction, bridge, numberOfTrying);
    }


    public static boolean retry(String command) {
        if(Objects.equals(command, QUIT)) {
            return false;
        }
        if(Objects.equals(command, RESTART)) {
            return true;
        }
        return true;
    }

    public static int getAnswerCount(String direction) {
        triedAnswers.add(direction);
        System.out.println(triedAnswers);
        return triedAnswers.size();
    }

    public static void returnToPreviousStatus(List<String> upstairsBridge, List<String> downstairsBridge) {
        upstairsBridge.remove(upstairsBridge.size()-1);
        downstairsBridge.remove(downstairsBridge.size()-1);
        triedAnswers.remove(triedAnswers.size()-1);
    }

    public static boolean whetherGameSuccess(List<String> upstairsBridge, List<String> downstairsBridge) {
        return !upstairsBridge.contains(WRONG) && !downstairsBridge.contains(WRONG);
    }
}
