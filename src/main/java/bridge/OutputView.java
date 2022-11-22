package bridge;

import java.util.List;

enum Brackets {
    START("[ "), BLANK(" "), MATCH("O"), MISMATCH("X"), MIDDLE(" | "), END(" ]");
    private final String symbol;

    Brackets(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_RESULT_MESSAGE = "게임 성공 여부: ";
    private static final String TRIAL_MESSAGE = "총 시도한 횟수: ";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printMap(int step, List<String> answer, List<String> submitted) {
        printUpperBridge(step, answer, submitted);
        printLowerBridge(step, answer, submitted);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(int howFar, List<String> answer, List<String> submitted) {
        System.out.println(RESULT_MESSAGE);
        printMap(howFar, answer, submitted);
    }

    public void printUpperBridge(int step, List<String> answer, List<String> submitted) {
        System.out.print(Brackets.START.getSymbol());
        for (int loop = 0; loop < step; loop++) {
            String loopAnswer = answer.get(loop);
            String loopSubmitted = submitted.get(loop);
            isMiddle(loop);
            isMatch(UP, loopSubmitted, loopAnswer);
            isMismatch(UP, loopSubmitted, loopAnswer);
            isBlank(DOWN, loopSubmitted);
        }
        System.out.println(Brackets.END.getSymbol());
    }

    public void printLowerBridge(int step, List<String> answer, List<String> submitted) {
        System.out.print(Brackets.START.getSymbol());
        for (int loop = 0; loop < step ; loop++) {
            String loopAnswer = answer.get(loop);
            String loopSubmitted = submitted.get(loop);
            isMiddle(loop);
            isMatch(DOWN, loopSubmitted, loopAnswer);
            isMismatch(DOWN, loopSubmitted, loopAnswer);
            isBlank(UP, loopSubmitted);
        }
        System.out.println(Brackets.END.getSymbol());
    }

    public void printSuccessOrFail(BridgeGame game) {
        String SorF = "실퍠";
        System.out.print(SUCCESS_RESULT_MESSAGE);
        if (game.isSuccess) {
            SorF = "성공";
        }
        System.out.println(SorF);
    }

    public void printTrialCount(BridgeGame game) {
        System.out.print(TRIAL_MESSAGE);
        System.out.println(game.trialCount);
    }

    public void isMiddle(int loop) {
        if (loop != 0) {
            System.out.print(Brackets.MIDDLE.getSymbol());
        }
    }

    public void isMatch(String upOrDown, String submitted, String answer) {
        if (submitted.equals(upOrDown) && submitted.equals(answer)) {
            System.out.print(Brackets.MATCH.getSymbol());
        }
    }

    public void isMismatch(String upOrDown, String submitted, String answer) {
        if (submitted.equals(upOrDown) && !submitted.equals(answer)) {
            System.out.print(Brackets.MISMATCH.getSymbol());
        }
    }

    public void isBlank(String upOrDown, String submitted) {
        if (submitted.equals(upOrDown)) {
            System.out.print(Brackets.BLANK.getSymbol());
        }
    }
}
