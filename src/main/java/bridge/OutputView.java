package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String GAME_WIN_RESULT = "게임 성공 여부: %s\n총 시도한 횟수: %d";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Bridge> bridges) {
        List<String> upBridge = getUpBridgeList(bridges);
        List<String> downBridge = getDownBridgeList(bridges);
        System.out.println(getListToString(upBridge));
        System.out.println(getListToString(downBridge));
    }

    private List<String> getUpBridgeList(List<Bridge> bridges) {
        List<String> result = new ArrayList<>();
        for (Bridge bridge : bridges) {
            result.add(bridge.getUpShape());
        }
        return result;
    }

    private List<String> getDownBridgeList(List<Bridge> bridges) {
        List<String> result = new ArrayList<>();
        for (Bridge bridge : bridges) {
            result.add(bridge.getDownShape());
        }
        return result;
    }

    private String getListToString(List<String> bridge){
        return "[ " + String.join(" | ", bridge) + " ]";
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<Bridge> bridges, String gameResult, int count) {
        System.out.println(FINAL_GAME_RESULT);
        printMap(bridges);
        System.out.printf(GAME_WIN_RESULT, gameResult, count);
    }
}
