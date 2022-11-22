package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String GAME_SUCCESS_RESULT = "게임 성공 여부";
    private static final String TOTAL_TRY_TIME = "총 시도한 횟수";
    private static final String BRIDGE_START = "[ ";
    private static final String BRIDGE_MID = " | ";
    private static final String BRIDGE_END = " ]";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String NONE = " ";
    private static final String CORRECT = "O";
    private static final String IN_CORRECT = "X";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<List<String>> bridgeCorrects) {
        brSizeOne(bridgeCorrects);
        brSizeTwoPlus(bridgeCorrects);
    }

    private static void brSizeOne(List<List<String>> bridgeCorrects) {
        if (bridgeCorrects.size() == 1) {
            System.out.print(BRIDGE_START);
            up(bridgeCorrects, 0);
            System.out.println(BRIDGE_END);
            System.out.print(BRIDGE_START);
            down(bridgeCorrects, 0);
            System.out.println(BRIDGE_END);
        }
    }

    private static void brSizeTwoPlus(List<List<String>> bridgeCorrects) {
        int bridgeSize = bridgeCorrects.size();
        if (bridgeSize >= 2) {
            System.out.print(BRIDGE_START);
            upWork(bridgeCorrects, bridgeSize);
            downWork(bridgeCorrects, bridgeSize);
            System.out.println(BRIDGE_END);
        }
    }

    private static void upWork(List<List<String>> bridgeCorrects, int bridgeSize) {
        for (int i = 0; i < bridgeSize - 1; i++) {
            up(bridgeCorrects, i);
            System.out.print(BRIDGE_MID);
        }
        up(bridgeCorrects, bridgeSize - 1);
        System.out.println(BRIDGE_END);
    }

    private static void downWork(List<List<String>> bridgeCorrects, int bridgeSize) {
        System.out.print(BRIDGE_START);
        for (int i = 0; i < bridgeSize - 1; i++) {
            down(bridgeCorrects, i);
            System.out.print(BRIDGE_MID);
        }
        down(bridgeCorrects, bridgeSize - 1);
    }

    private static void up(List<List<String>> bridgeCorrects, int i) {
        if (bridgeCorrects.get(i).get(0).equals(UP) && bridgeCorrects.get(i).get(1).equals(CORRECT)) {
            System.out.print(CORRECT);
            return;
        }
        if (bridgeCorrects.get(i).get(0).equals(UP) && bridgeCorrects.get(i).get(1).equals(IN_CORRECT)) {
            System.out.print(IN_CORRECT);
            return;
        }
        System.out.print(NONE);
    }

    private static void down(List<List<String>> bridgeCorrects, int i) {
        if (bridgeCorrects.get(i).get(0).equals(DOWN) && bridgeCorrects.get(i).get(1).equals(CORRECT)) {
            System.out.print(CORRECT);
            return;
        }
        if (bridgeCorrects.get(i).get(0).equals(DOWN) && bridgeCorrects.get(i).get(1).equals(IN_CORRECT)) {
            System.out.print(IN_CORRECT);
            return;
        }
        System.out.print(NONE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<List<String>> bridgeCorrects, String isSuccess, int cnt) {
        System.out.println(FINAL_GAME_RESULT);
        printMap(bridgeCorrects);
        System.out.println();
        System.out.println(GAME_SUCCESS_RESULT + ": " + isSuccess);
        System.out.println(TOTAL_TRY_TIME + ": " + cnt);
    }

    public static void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }
}
