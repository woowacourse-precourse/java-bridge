package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    static final int CALCULATE_INSERT_INDEX = 1;
    static final int SIZE_NULL = 0;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public List<String> storeRightMap(List<String> bridgeMap, int mapIndex) {
        int insertIndex = mapIndex + CALCULATE_INSERT_INDEX;
        if (bridgeMap.size() == SIZE_NULL) {
            bridgeMap.add("[");
            bridgeMap.add("]");
        }
        bridgeMap.add(insertIndex," O ");
        printResult(bridgeMap);
        bridgeMap.set(insertIndex,bridgeMap.get(insertIndex).concat("|"));
        return bridgeMap;
    }

    public List<String> storeAnotherMap(List<String> bridgeMap, int mapIndex) {
        int insertIndex = mapIndex + CALCULATE_INSERT_INDEX;
        if (bridgeMap.size() == SIZE_NULL) {
            bridgeMap.add("[");
            bridgeMap.add("]");
        }
        bridgeMap.add(insertIndex,"   ");
        printResult(bridgeMap);
        bridgeMap.set(insertIndex,bridgeMap.get(insertIndex).concat("|"));
        return bridgeMap;
    }

    public List<String> storeAnotherWrongMap(List<String> bridgeMap, int mapIndex) {
        int insertIndex = mapIndex + CALCULATE_INSERT_INDEX;
        if (bridgeMap.size() == SIZE_NULL) {
            bridgeMap.add("[");
            bridgeMap.add("]");
        }
        bridgeMap.add(insertIndex,"   ");
        printResult(bridgeMap);
        return bridgeMap;
    }

    public List<String> storeWrongMap(List<String> bridgeMap, int mapIndex) {
        int insertIndex = mapIndex + CALCULATE_INSERT_INDEX;
        if (bridgeMap.size() == SIZE_NULL) {
            bridgeMap.add("[");
            bridgeMap.add("]");
        }
        bridgeMap.add(insertIndex," X ");
        printResult(bridgeMap);
        return bridgeMap;
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridgeMap) {
        for (String bridgeInfo : bridgeMap) {
            System.out.print(bridgeInfo);
        }
        System.out.println();
    }
}
