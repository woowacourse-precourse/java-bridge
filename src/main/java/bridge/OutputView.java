package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> totalMap) {
        drawMap(totalMap.get(0));
        drawMap(totalMap.get(1));
    }

    public void makeMap(List<String> bridge, List<String> moving) {
        List<List<String>> totalMap = new ArrayList<List<String>>(Arrays.asList(new ArrayList<String>(),new ArrayList<String>()));

        for (int i = 0; i < moving.size(); i++) {
            addUpMap(bridge.get(i), moving.get(i),totalMap );
            addDownMap(bridge.get(i), moving.get(i),totalMap );
        }
        printMap(totalMap);
    }

    private List<List<String>> addUpMap(String bridge,String moving,List<List<String>> totalMap) {
        if (isSameString(bridge, moving)) {
            if (isUpOrDown(moving)) {
                addString(totalMap, "O", " ");
            }
            if (!isUpOrDown(moving)) {
                addString(totalMap, " ", "O");
            }
        }
        return totalMap;
    }

    private List<List<String>> addDownMap(String bridge,String moving,List<List<String>> totalMap) {
        if (!isSameString(bridge, moving)) {
            if (isUpOrDown(moving)) {
                addString(totalMap, "X", " ");
            }
            if (!isUpOrDown(moving)) {
                addString(totalMap, " ", "X");
            }
        }
        return totalMap;
    }

    private List<List<String>> addString(List<List<String>> totalMap, String str1, String str2) {
        totalMap.get(0).add(str1);
        totalMap.get(1).add(str2);
        return totalMap;
    }

    private void drawMap(List<String> map) {
        System.out.print("[");
        for (int i = 0; i < map.size() - 1; i++) {
            System.out.print(" " + map.get(i) + " |");
        }
        System.out.println(" " + map.get(map.size() - 1) + " ]");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    private boolean isSameString(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        return false;
    }

    private boolean isUpOrDown(String str) {
        if (str.equals("U")) {
            return true;
        }
        return false;
    }
}
