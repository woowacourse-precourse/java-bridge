package bridge.view;

import bridge.model.Direction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> dir, boolean isFail) {
        final List<String> key = List.of("U", "D");
        Map<String, List<String>> initialMap = initMap(dir.size());
        Map<String, List<String>> map = setWay(initialMap, dir, isFail);

        final String prefix = "[ ";
        final String suffix = " ]";
        for (String s : key) {
            System.out.println(prefix + String.join(" | ", map.get(s)) + suffix);
        }
        System.out.println();
    }

    private Map<String, List<String>> setWay(Map<String, List<String>> map,
        List<String> dir, boolean isFail) {

        for (int i = 0; i < dir.size(); i++) {
            String success = getSuccessOrFail(i, dir, isFail);
            List<String> way = map.get(dir.get(i));
            way.set(i, success);
            map.put(dir.get(i), way);
        }
        return map;
    }

    private String getSuccessOrFail(int i, List<String> dir, boolean isFail) {
        final String success = "O";
        final String fail = "X";
        if (isFail && i + 1 == dir.size()) {
            return fail;
        }
        return success;
    }

    private Map<String, List<String>> initMap(int size) {
        Map<String, List<String>> dirMap = new HashMap<>();
        for (Direction dir : Direction.values()) {
            List<String> initialMap = generateMap(size);
            dirMap.put(dir.toString(), initialMap);
        }

        return dirMap;
    }

    private List<String> generateMap(int size) {
        String initialValue = " ";
        String[] map = new String[size];
        Arrays.fill(map, initialValue);
        return new ArrayList<>(Arrays.asList(map));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isFail, int times) {
        System.out.println(GameMsg.SUCCESS_MSG.getMsg() + getGameResult(isFail));
        System.out.println(GameMsg.TRY_COUNT_MSG.getMsg() + times);
    }

    private String getGameResult(boolean isFail) {
        String success = "성공";
        String fail = "실패";

        if (isFail) {
            return fail;
        }
        return success;
    }
}