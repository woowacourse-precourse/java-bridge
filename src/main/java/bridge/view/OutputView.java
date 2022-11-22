package bridge.view;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "\n다리 건너기 게임을 시작합니다.\n";

    static StringBuilder up;
    static StringBuilder down;
    static final String START_POINT = "[ ";
    static final String END_POINT = " ]";
    static final String SPLIT = " | ";
    static final String[] PASS_FAIL = {"O", "X"};
    static final String EMPTY = " ";

    // report
    private static final String REPORT_TITLE = "\n최종 게임 결과";
    private static final String REPORT_RESULT = "\n게임 성공 여부: ";
    private static final String REPORT_RETRY = "총 시도한 횟수: ";

    public OutputView() {
        up = new StringBuilder();
        down = new StringBuilder();
    }

    public OutputView(List<String> asList) {
    }

    public static String getUpDown() {
        return up.toString() + "\n" + down.toString();
    }

    public void printStart(){
        System.out.println(START_MESSAGE);
    }

    public void print(String string){
        System.out.println(string);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> steps, List<String> bridge) {
        resetMap();
        appendToBoth(START_POINT);
        for (int i = 0; i < steps.size(); i++) {
            drowBlocks(bridge.get(i), steps.get(i));
            appendToBoth(SPLIT);
        }
        endMap();
        System.out.println(up.toString() + "\n" + down.toString());
    }

    private static void resetMap() {
        up.setLength(0);
        down.setLength(0);
    }

    private static void endMap() {
        up.delete(up.length() - SPLIT.length(), up.length());
        down.delete(down.length() - SPLIT.length(), down.length());
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

    private static void drowBlocks(String answer, String upDown) {
        int passFail = 1;
        if (answer.equals(upDown)) passFail = 0;

        if (upDown.equals("U")) {
            appendToBoth(PASS_FAIL[passFail], EMPTY);
        }
        if (upDown.equals("D")) {
            appendToBoth(EMPTY, PASS_FAIL[passFail]);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean failFlag, int tryCount) {
        String result = "";
        if (failFlag) result = "성공";
        if (!failFlag) result = "실패";

        System.out.println(REPORT_TITLE);
        System.out.println(up.toString() + "\n" + down.toString());
        System.out.println(REPORT_RESULT + result);
        System.out.println(REPORT_RETRY + tryCount);
    }
}
