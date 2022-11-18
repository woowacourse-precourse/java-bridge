package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String UP = "U";
    private static final String BLANK = " ";
    private static final String SEPARATOR = "|";
    private static final String OPEN = "[";
    private static final String CLOSE = "]";
    public static final String SUCCESS = "성공";
    public static final String FAIL = "실패";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Result result) {
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        openParenthesis(first, second);
        printMiddleMap(result, first, second);
        closeParenthesis(first, second);
        System.out.println(first + "\n" + second);
    }

    private void printMiddleMap(Result result, StringBuilder first, StringBuilder second) {
        for (int i = 0; i < result.getState().size(); i++) {
            makeSeparator(first, second, i);
            if (checkUpDown(result.getInput(i))) {
                first.append(BLANK).append(result.getState(i)).append(BLANK);
                second.append(BLANK).append(BLANK).append(BLANK);
                continue;
            }
            first.append(BLANK).append(BLANK).append(BLANK);
            second.append(BLANK).append(result.getState(i)).append(BLANK);
        }
    }

    private static void makeSeparator(StringBuilder first, StringBuilder second, int index) {
        if (index != 0) {
            first.append(SEPARATOR);
            second.append(SEPARATOR);
        }
    }

    private boolean checkUpDown(String input) {
        return input.equals(UP);
    }

    private void closeParenthesis(StringBuilder first, StringBuilder second) {
        first.append(CLOSE);
        second.append(CLOSE);
    }

    private void openParenthesis(StringBuilder first, StringBuilder second) {
        first.append(OPEN);
        second.append(OPEN);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result, int count) {
        System.out.println();
        System.out.println("최종 게임 결과");
        printMap(result);
        System.out.println();
        System.out.println("게임 성공 여부: " + changeSuccessOrFail(result.movable()));
        System.out.println("총 시도한 횟수: " + count);
    }

    private String changeSuccessOrFail(boolean movable) {
        if (movable) {
            return SUCCESS;
        }
        return FAIL;
    }

    public void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void printInputBridgeSize() {
        System.out.println();
        System.out.println("다리의 길이를 입력해 주세요.");
    }

    public void printMove() {
        System.out.println();
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printRestart() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
}
