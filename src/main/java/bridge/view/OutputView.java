package bridge.view;

import java.util.ArrayList;
import java.util.List;

import bridge.model.CrossBridgeType;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> usedMap, boolean isCross) {
        System.out.println("usedMap: " + usedMap);
        System.out.println("");
        StringBuilder result = new StringBuilder("[");
        result.append(String.join("|", outputMapBuilder(usedMap, CrossBridgeType.UPPER_BRIDGE, isCross)));
        result.append("]\n[");
        result.append(String.join("|", outputMapBuilder(usedMap, CrossBridgeType.DOWN_BRIDGE, isCross)));
        result.append("]\n");
        System.out.println(result);
    }

    public List<String> outputMapBuilder(List<String> usedMap, CrossBridgeType crossBridgeType, boolean isCross) {
        int mapSize = usedMap.size();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < mapSize; i++) {
            if (i == (mapSize - 1) && !isCross) {
                result.add(blockMapStatus(usedMap.get(i), crossBridgeType));
                break;
            }
            result.add(crossMapStatus(usedMap.get(i), crossBridgeType));
        }
        return result;
    }

    public String blockMapStatus(String bridge, CrossBridgeType crossBridgeType) {
        if (Integer.parseInt(bridge) != crossBridgeType.getBinaryKey())
            return " X ";
        return "   ";

    }

    public String crossMapStatus(String bridge, CrossBridgeType crossBridgeType) {

        if (Integer.parseInt(bridge) == crossBridgeType.getBinaryKey())
            return " O ";
        return "   ";

    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
