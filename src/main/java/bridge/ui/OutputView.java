package bridge.ui;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private final String startMap = "[ ";
    private final String endMap = " ]";
    private final String separator = " | ";
    private final String resultOfGame = "최종 게임 결과";
    private final String resultOfGameSuccess = "게임 성공 여부: ";
    private final String resultOfGameTrial = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> route, boolean isSuccess) {
        List<StringBuilder> maps = List.of(new StringBuilder(startMap), new StringBuilder(startMap));
        if (isSuccess) {
            printMapIfIsSuccess(route, maps);
            System.out.println();
            return;
        }
        printMapIfIsNotSuccess(route, maps);
        System.out.println();
    }

    private void printMapIfIsNotSuccess(List<String> route, List<StringBuilder> maps) {
        System.out.println(makeUpStringIfFailed(route, maps.get(0)));
        System.out.println(makeDownStringIfFailed(route, maps.get(1)));
    }

    private void printMapIfIsSuccess(List<String> route, List<StringBuilder> maps) {
        makeUpString(route, maps.get(0), route.size());
        makeDownString(route, maps.get(1), route.size());
        maps.get(0).delete(maps.get(0).length()-3,maps.get(0).length()).append(endMap);
        maps.get(1).delete(maps.get(1).length()-3,maps.get(1).length()).append(endMap);
        System.out.println(maps.get(0).toString());
        System.out.println(maps.get(1).toString());
    }


    private String makeDownStringIfFailed(List<String> route, StringBuilder downBridge) {
        makeDownString(route, downBridge, route.size() - 1);
        if (route.get(route.size() - 1).equals("U")) {
            downBridge.append(" ").append(endMap);
            return downBridge.toString();
        }
        return downBridge.append("X").append(endMap).toString();
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
                upBridge.append(" " + separator);
                continue;
            }
            upBridge.append("O" + separator);
        }
    }

    private void makeDownString(List<String> route, StringBuilder downBridge, int size) {
        for (int i = 0; i < size; i++) {
            if (route.get(i).equals("U")) {
                downBridge.append(" " + separator);
                continue;
            }
            downBridge.append("O" + separator);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> route, boolean isSuccess, int trialNum) {
        System.out.println(resultOfGame);
        printMap(route, isSuccess);
        System.out.println();
        printResultSuccess(isSuccess);
        printResultTrial(trialNum);
    }

    private void printResultSuccess(boolean isSuccess) {
        if (isSuccess) {
            System.out.println(resultOfGameSuccess + "성공");
            return;
        }
        System.out.println(resultOfGameSuccess + "실패");
    }

    private void printResultTrial(int trialNum) {
        System.out.println(resultOfGameTrial + trialNum);
    }
}
