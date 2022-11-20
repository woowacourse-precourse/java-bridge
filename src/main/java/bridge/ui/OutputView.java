package bridge.ui;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String startMap = "[ ";
    private final String endMap = " ]";
    private final String Separator = " | ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> route, boolean isEnd, boolean isSuccess) {
        List<StringBuilder> maps = List.of(new StringBuilder(startMap), new StringBuilder(startMap));
        if (isEnd) {
            printMapIfIsEnd(route, maps, isSuccess);
            return;
        }
        printMapIfIsNotEnd(route, maps);
    }

    private void printMapIfIsEnd(List<String> route, List<StringBuilder> maps, boolean isSuccess) {
        if (isSuccess) {
            System.out.println(makeUpStringIfSuccess(route, maps.get(0)));
            System.out.println(makeDownStringIfSuccess(route, maps.get(1)));
            return;
        }
        System.out.println(makeUpStringIfFailed(route, maps.get(0)));
        System.out.println(makeDownStringIfFailed(route, maps.get(1)));
    }

    private void printMapIfIsNotEnd(List<String> route, List<StringBuilder> maps) {
        makeUpString(route, maps.get(0), route.size());
        makeDownString(route, maps.get(1), route.size());
        System.out.println(maps.get(0).toString());
        System.out.println(maps.get(1).toString());
    }

    private String makeDownStringIfSuccess(List<String> route, StringBuilder downBridge) {
        makeDownString(route, downBridge, route.size() - 1);
        if (route.get(route.size() - 1).equals("U")) {
            downBridge.append(" ").append(endMap);
            return downBridge.toString();
        }
        return downBridge.append("O").append(endMap).toString();
    }

    private String makeDownStringIfFailed(List<String> route, StringBuilder downBridge) {
        makeDownString(route, downBridge, route.size() - 1);
        if (route.get(route.size() - 1).equals("U")) {
            downBridge.append(" ").append(endMap);
            return downBridge.toString();
        }
        return downBridge.append("X").append(endMap).toString();
    }

    private String makeUpStringIfSuccess(List<String> route, StringBuilder upBridge) {
        makeUpString(route, upBridge, route.size() - 1);
        if (route.get(route.size() - 1).equals("D")) {
            upBridge.append(" ").append(endMap);
            return upBridge.toString();
        }
        return upBridge.append("O").append(endMap).toString();
    }

    private String makeUpStringIfFailed(List<String> route, StringBuilder upBridge) {
        makeUpString(route, upBridge, route.size() - 1);
        if (route.get(route.size() - 1).equals("D")) {
            upBridge.append(" ").append(endMap);
            return upBridge.toString();
        }
        return upBridge.append("X").append(endMap).toString();
    }


    private void makeUpString(List<String> route, StringBuilder upBridge, int size) {
        for (int i = 0; i < size; i++) {
            if (route.get(i).equals("D")) {
                upBridge.append(" " + Separator);
                continue;
            }
            upBridge.append("O");
        }
    }

    private void makeDownString(List<String> route, StringBuilder downBridge, int size) {
        for (int i = 0; i < size; i++) {
            if (route.get(i).equals("U")) {
                downBridge.append(" " + Separator);
                continue;
            }
            downBridge.append("O");
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
