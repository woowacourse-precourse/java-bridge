package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    enum ladder {
        START("[ "),
        SPACE(" "),
        END(" ]"),
        DIVIDER(" | "),
        CORRECT("O"),
        WRONG("X");

        final String sign;

        ladder(String sign) {
            this.sign = sign;
        }

        public String getSign() {
            return this.sign;
        }
    }

    final static String UP = "U";
    final static String DOWN = "D";
    final static String FIRST = "F";
    final static String SECOND = "S";
    final static String FINAL_RESULT = "최종 게임 결과";
    final static String SUCCEEDED = "게임 성공 여부: ";
    final static String SUCCESS = "성공";
    final static String FAIL = "실패";
    final static String ATTEMPT = "\n총 시도한 횟수: ";
    static BridgeGame bm = new BridgeGame();
    static InputView iv = new InputView();


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean printMap(List<String> upOrDown) {
        for (int i = 0; i < upOrDown.size(); i++) {
            String userInput = bm.move();
            boolean canMove = startLadder(i, upOrDown, userInput);
            if (!canMove) {
                return bm.retry(iv.readGameCommand());
            }
        }
        return false;
    }

    public boolean startLadder(int index, List<String> upOrDown, String userInput) {
        System.out.print(ladder.START.getSign());
        boolean isFirstRowTrue = firstRow(index, upOrDown, userInput);
        System.out.print(ladder.START.getSign());
        boolean isSecondRowTrue = secondRow(index, upOrDown, userInput);
        return isFirstRowTrue && isSecondRowTrue;
    }

    public static boolean firstRow(int index, List<String> upOrDown, String userInput) {
        printPreviousIndexRow(upOrDown, index, FIRST);
        if (printCurrentIndexRow(upOrDown.get(index), userInput, DOWN)) return false;
        System.out.print(ladder.END.getSign());
        System.out.println();
        return true;
    }

    public static boolean secondRow(int index, List<String> upOrDown, String userInput) {
        printPreviousIndexRow(upOrDown, index, SECOND);
        if (printCurrentIndexRow(upOrDown.get(index), userInput, UP)) return false;
        System.out.print(ladder.END.getSign());
        System.out.println();
        return true;
    }

    public static void printPreviousIndexRow(List<String> upOrDown, int index, String firstOrSecond) {
        for (int i = 0; i < index; i++) {
            previousIndexRows(upOrDown, i, firstOrSecond);
        }
    }

    public static void previousIndexRows(List<String> upOrDown, int index, String firstOrSecond) {
        if (firstOrSecond.equals(FIRST)) {
            if (upOrDown.get(index).equals(UP)) System.out.print(ladder.CORRECT.getSign());
            if (upOrDown.get(index).equals(DOWN)) System.out.print(ladder.SPACE.getSign());
        }
        if (firstOrSecond.equals(SECOND)) {
            if (upOrDown.get(index).equals(DOWN)) System.out.print(ladder.CORRECT.getSign());
            if (upOrDown.get(index).equals(UP)) System.out.print(ladder.SPACE.getSign());
        }
        System.out.print(ladder.DIVIDER.getSign());
    }

    public static boolean printCurrentIndexRow(String current, String userInput, String direction) {
        if (!(current.equals(userInput)) && current.equals(direction)) {
            System.out.print(ladder.WRONG.getSign());
            System.out.print(ladder.END.getSign() + "\n");
            return true;
        }
        if (!(current.equals(userInput)) && current.equals(invert(direction))) System.out.print(ladder.SPACE.getSign());
        if (current.equals(userInput) && userInput.equals(invert(direction)))
            System.out.print(ladder.CORRECT.getSign());
        if (current.equals(userInput) && userInput.equals(direction)) System.out.print(ladder.SPACE.getSign());
        return false;
    }

    public static String invert(String invert) {
        if (invert.equals(UP)) return DOWN;
        return UP;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridgeMaker) {
        System.out.println(FINAL_RESULT);
        startLadder(BridgeGame.totalCount - 1, bridgeMaker, BridgeGame.lastUserInput);
        if (!BridgeGame.isComplete) System.out.println(SUCCEEDED + FAIL + ATTEMPT + BridgeGame.attempt);
        if (BridgeGame.isComplete) System.out.println(SUCCEEDED + SUCCESS + ATTEMPT + BridgeGame.attempt);
    }

    public static void main(String[] args) {

    }
}
