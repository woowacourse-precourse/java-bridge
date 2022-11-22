package bridge;

public class OutputView {
    private static final String BRIDGE_START = "[";
    private static final String BRIDGE_END = "]\n";
    private static final String STEP = " %s ";
    private static final String BLANK = " ";
    private static final String BAR = "|";
    private static final String GAME_SUCCESS_MESSAGE = "게임 성공 여부: ";
    private static final String NUMBER_OF_CHALLENGES = "총 시도한 횟수: ";
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과\n";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";

    private static StringBuilder left = new StringBuilder();
    private static StringBuilder right = new StringBuilder();

    public void printMap() {
        System.out.printf(BRIDGE_START + left + BRIDGE_END);
        System.out.printf(BRIDGE_START + right + BRIDGE_END + "\n");
    }

    public void writeMap(boolean isUP, String ox) {
        writeBar();
        writeUpOrDown(isUP, ox);
    }

    private void writeBar() {
        if (left.length() > 0) {
            left.append(BAR);
            right.append(BAR);
        }
    }

    private void writeUpOrDown(boolean isUP, String ox) {
        if (isUP) {
            left.append(String.format(STEP, ox));
            right.append(String.format(STEP, BLANK));
            return;
        }
        left.append(String.format(STEP, BLANK));
        right.append(String.format(STEP, ox));

    }



    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean isSuccess, int count) {
        System.out.printf(GAME_RESULT_MESSAGE);
        printMap();
        System.out.println(GAME_SUCCESS_MESSAGE + result(isSuccess));
        System.out.println(NUMBER_OF_CHALLENGES + count);
    }

    private String result(boolean isSuccess) {
        if (isSuccess) {
            return SUCCESS;
        }
        return FAIL;
    }

    public void initMap() {
        left = new StringBuilder();
        right = new StringBuilder();
    }
}