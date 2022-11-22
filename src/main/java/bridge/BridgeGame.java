package bridge;

import static utils.Constant.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    static List<String> upstairsBridge = new ArrayList<>();
    static List<String> downstairsBridge = new ArrayList<>();
    static List<String> triedAnswers = new ArrayList<>();

    public List<String> upstairsBridge () {
        return upstairsBridge;
    }
    public List<String> downstairsBridge () {
        return downstairsBridge;
    }

    public void getUpstairsBridge (String direction, List<String> bridge, int numberOfTrying) {
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
    }

    public void getDownstairsBridge (String direction, List<String> bridge, int numberOfTrying) {
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
    }

    public void move(String direction, List<String> bridge, int numberOfTrying) {
        getUpstairsBridge(direction, bridge, numberOfTrying);
        getDownstairsBridge(direction, bridge, numberOfTrying);
    }


    public static boolean retry(String command) {
        if(Objects.equals(command, QUIT)) {
            return false;
        }
        if (Objects.equals(command, RESTART)) {
            return true;
        }
        return true;
    }

    public static int getTriedAnswerCount(String direction) {
        triedAnswers.add(direction);
        return triedAnswers.size();
    }

    public static void returnToPreviousStatus(List<String> upstairsBridge, List<String> downstairsBridge) {
        upstairsBridge.remove(upstairsBridge.size()-1);
        downstairsBridge.remove(downstairsBridge.size()-1);
        triedAnswers.remove(triedAnswers.size()-1);
    }

    public static boolean checkWrongAnswer(List<String> upstairsBridge, List<String> downstairsBridge) {
        return !upstairsBridge.contains(WRONG) && !downstairsBridge.contains(WRONG) && upstairsBridge.size() != 0;
    }

    public static boolean getGameCompleteStatus(List<String> upstairsBridge, List<String> downstairsBridge, int size) {
        return (checkWrongAnswer(upstairsBridge, downstairsBridge) && upstairsBridge.size() >= size);
    }
}
