package view;

import java.util.List;

public class OutputView {

    static List<String> bridge;
    static StringBuilder up;
    static StringBuilder down;
    static final String START_POINT = "[ ";
    static final String END_POINT = " ]";
    static final String SPLIT = " | ";
    static final String[] PASS_FAIL = {"O", "X"};
    static final String EMPTY = " ";
    static boolean failFlag = true;

    public OutputView(List<String> bridge) {
        this.bridge = bridge;
        up = new StringBuilder();
        down = new StringBuilder();
    }

    public static StringBuilder getUp() {
        return up;
    }

    public static StringBuilder getDown() {
        return down;
    }

    public static boolean isFailFlag() {
        return failFlag;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> steps) {
        appendToBoth(START_POINT);

        for (int i=0; i<steps.size(); i++) {
            drowBlocks(i, steps.get(i));
            appendToBoth(SPLIT);
        }

        endMap();
        System.out.println(up.toString()+"\n"+down.toString());
    }

    private static void endMap() {
        up.delete(up.length()-SPLIT.length(),up.length());
        down.delete(down.length()-SPLIT.length(),down.length());
        appendToBoth(END_POINT);
    }

    private static void appendToBoth(String print) {
        up.append(print);
        down.append(print);
    }

    private static void appendToBoth(String print1, String print2) {
        up.append(print1);
        down.append(print2);
    }

    private static void drowBlocks(int i, String upDown) {
        int passFail = getPassFail(i, upDown);

        if (upDown.equals("U")) {
            appendToBoth(PASS_FAIL[passFail], EMPTY);
        }
        if (upDown.equals("D")) {
            appendToBoth(EMPTY, PASS_FAIL[passFail]);
        }
    }

    private static int getPassFail(int i, String s) {
        int passFail = 1;

        if (bridge.get(i).equals(s)) passFail = 0;

        return passFail;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        // TODO document why this method is empty
    }
}
