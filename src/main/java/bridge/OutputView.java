package bridge;

import java.util.List;
import console.Ladder;
import console.OutputMessage;
/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
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
        System.out.print(Ladder.START.getSign());
        boolean isFirstRowTrue = firstRow(index, upOrDown, userInput);
        System.out.print(Ladder.START.getSign());
        boolean isSecondRowTrue = secondRow(index, upOrDown, userInput);
        return isFirstRowTrue && isSecondRowTrue;
    }

    public static boolean firstRow(int index, List<String> upOrDown, String userInput) {
        printPreviousIndexRow(upOrDown, index, OutputMessage.FIRST.getMessage());
        if (printCurrentIndexRow(upOrDown.get(index), userInput, OutputMessage.DOWN.getMessage())) return false;
        System.out.print(Ladder.END.getSign());
        System.out.println();
        return true;
    }

    public static boolean secondRow(int index, List<String> upOrDown, String userInput) {
        printPreviousIndexRow(upOrDown, index, OutputMessage.SECOND.getMessage());
        if (printCurrentIndexRow(upOrDown.get(index), userInput, OutputMessage.UP.getMessage())) return false;
        System.out.print(Ladder.END.getSign());
        System.out.println();
        return true;
    }

    public static void printPreviousIndexRow(List<String> upOrDown, int index, String firstOrSecond) {
        for (int i = 0; i < index; i++) {
            previousIndexRows(upOrDown, i, firstOrSecond);
        }
    }

    public static void previousIndexRows(List<String> upOrDown, int index, String firstOrSecond) {
        if (firstOrSecond.equals(OutputMessage.FIRST.getMessage())) {
            if (upOrDown.get(index).equals(OutputMessage.UP.getMessage())) System.out.print(Ladder.CORRECT.getSign());
            if (upOrDown.get(index).equals(OutputMessage.DOWN.getMessage())) System.out.print(Ladder.SPACE.getSign());
        }
        if (firstOrSecond.equals(OutputMessage.SECOND.getMessage())) {
            if (upOrDown.get(index).equals(OutputMessage.DOWN.getMessage())) System.out.print(Ladder.CORRECT.getSign());
            if (upOrDown.get(index).equals(OutputMessage.UP.getMessage())) System.out.print(Ladder.SPACE.getSign());
        }
        System.out.print(Ladder.DIVIDER.getSign());
    }

    public static boolean printCurrentIndexRow(String current, String userInput, String direction) {
        if (!(current.equals(userInput)) && current.equals(direction)) {
            System.out.print(Ladder.WRONG.getSign());
            System.out.print(Ladder.END.getSign() + "\n");
            return true;
        }
        if (!(current.equals(userInput)) && current.equals(invert(direction))) System.out.print(Ladder.SPACE.getSign());
        if (current.equals(userInput) && userInput.equals(invert(direction)))
            System.out.print(Ladder.CORRECT.getSign());
        if (current.equals(userInput) && userInput.equals(direction)) System.out.print(Ladder.SPACE.getSign());
        return false;
    }

    public static String invert(String invert) {
        if (invert.equals(OutputMessage.UP.getMessage())) return OutputMessage.DOWN.getMessage();
        return OutputMessage.UP.getMessage();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridgeMaker) {
        System.out.println(OutputMessage.FINAL_RESULT.getMessage());
        startLadder(BridgeGame.totalCount - 1, bridgeMaker, BridgeGame.lastUserInput);
        if (!BridgeGame.isComplete) System.out.println(OutputMessage.SUCCEEDED.getMessage() + OutputMessage.FAIL.getMessage() + OutputMessage.ATTEMPT.getMessage() + BridgeGame.attempt);
        if (BridgeGame.isComplete) System.out.println(OutputMessage.SUCCEEDED.getMessage() + OutputMessage.SUCCESS.getMessage() + OutputMessage.ATTEMPT.getMessage() + BridgeGame.attempt);
    }

    public static void main(String[] args) {}
}
