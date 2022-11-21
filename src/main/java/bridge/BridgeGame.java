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
    public static final String RIGHT = "O";
    public static final String WRONG = "X";

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    static List<String> upstairsBridge = new ArrayList<>();
    static List<String> downstairsBridge = new ArrayList<>();
    static List<String> answerBridge = new ArrayList<>();
    public List<String> upstairsBridge () {
        return upstairsBridge;
    }

    public List<String> downstairsBridge () {
        return downstairsBridge;
    }


    public List<String> move(String direction, List<String> bridge, int numberOfTrying) {
        for(int eachBridge = 0; eachBridge<numberOfTrying; eachBridge++) {
            if (Objects.equals(direction, bridge.get(eachBridge))) {
                answerBridge.add(RIGHT);
            }
            if (!Objects.equals(direction, bridge.get(eachBridge))) {
                answerBridge.add(WRONG);
            }
        }
        return answerBridge;
    }

//    public static List<String> move(String direction, List<String> bridge) {
//        for (String eachBridge : bridge) {
//            if (Objects.equals(direction, eachBridge)) {
//                answerBridge.add(RIGHT);
//                continue;
//            }
//            if (!Objects.equals(direction, eachBridge)) {
//                answerBridge.add(WRONG);
//                break;
//            }
//        }
//        return answerBridge;
//    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public static int gameCount(String direction) {
        List<String> triedAnswers = new ArrayList<>();
        triedAnswers.add(direction);
        return triedAnswers.size();
    }
}
