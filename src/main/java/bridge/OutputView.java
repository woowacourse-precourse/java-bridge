package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class OutputView {
    
    public void printMap(List<List<String>> totalMap) {
        drawMap(totalMap.get(0));
        drawMap(totalMap.get(1));
        System.out.println();
    }

    public void makeMap(List<String> bridge, List<String> moving) {
        List<List<String>> totalMap = new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>()));

        for (int i = 0; i < moving.size(); i++) {
            addUpMap(bridge.get(i), moving.get(i), totalMap);
            addDownMap(bridge.get(i), moving.get(i), totalMap);
        }
        printMap(totalMap);
    }

    private List<List<String>> addUpMap(String bridge, String moving, List<List<String>> totalMap) {
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

    private List<List<String>> addDownMap(String bridge, String moving, List<List<String>> totalMap) {
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

   
    public void printResult(List<String> bridge, List<String> movingList, int gameTryNumber) {
        System.out.println("최종 게임 결과");
        makeMap(bridge, movingList);
        String result = "실패";
        if (isSameSize(bridge, movingList)) {
            result = "성공";
        }
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + gameTryNumber);
    }

    private boolean isSameString(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        return false;
    }

    private boolean isSameSize(List list1, List list2) {
        if (list1.size() == list2.size()) {
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
