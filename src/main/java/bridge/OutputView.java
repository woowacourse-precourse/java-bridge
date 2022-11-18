package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    final static String START = "[ ";
    final static String SPACE = " ";
    final static String END = " ]";
    final static String DIVIDER = " | ";
    final static String CORRECT = "O";
    final static String WRONG = "X";
    final static String UP = "U";
    final static String DOWN = "D";
    final static String REDO = "R";
    final static String QUIT = "Q";
    final static String FINAL_RESULT = "최종 게임 결과";
    final static String SUCCEEDED = "게임 성공 여부: ";
    final static String SUCCESS = "성공";
    final static String FAIL = "실패";
    final static String ATTEMPT = "\n총 시도한 횟수: ";
    static boolean isComplete;
    static InputView iv = new InputView();
    static String lastUserInput;
    static int totalCount = 0;
    static int attempt;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean printMap(List<String> upOrDown) {
        for (int i = 0; i < upOrDown.size(); i++){
            String userInput = iv.readMoving();
            totalCount++; attempt++;
            lastUserInput = userInput;
            if(!startLadder(i, upOrDown, userInput)){
                return redoOrQuit(iv.readGameCommand());
            }
        }
        return false;
    }

    public boolean startLadder(int index, List<String> upOrDown, String userInput){
        boolean isFirstRowTrue = firstRow(index, upOrDown, userInput);
        boolean isSecondRowTrue = secondRow(index, upOrDown, userInput);
        return isFirstRowTrue && isSecondRowTrue;
    }

    public static boolean firstRow(int index, List<String> upOrDown, String userInput) {
        System.out.print(START);
        printPreviousIndexFirstRow(upOrDown, index);
        if (!printCurrentIndexFirstRow(upOrDown.get(index), userInput)) return false;
        System.out.print(END);
        System.out.println();
        return true;
    }

    public static void printPreviousIndexFirstRow(List<String> upOrDown, int index) {
        for (int i = 0; i < index; i++) {
            if (upOrDown.get(i).equals(UP)) System.out.print(CORRECT);
            if (upOrDown.get(i).equals(DOWN)) System.out.print(SPACE);
            System.out.print(DIVIDER);
        }
    }

    public static boolean printCurrentIndexFirstRow(String current, String userInput) {
        if (!(current.equals(userInput)) && current.equals(DOWN)) {
            System.out.print(WRONG + END);
            System.out.println();
            return false;
        }
        if (!(current.equals(userInput)) && current.equals(UP)) System.out.print(SPACE);
        if (current.equals(userInput) && userInput.equals(UP)) System.out.print(CORRECT);
        if (current.equals(userInput) && userInput.equals(DOWN)) System.out.print(SPACE);
        return true;
    }


    public static boolean secondRow(int index, List<String> upOrDown, String userInput) {
        System.out.print(START);
        printPreviousIndexSecondRow(upOrDown, index);
        if (!printCurrentIndexSecondRow(upOrDown.get(index), userInput)) return false;
        System.out.print(END);
        System.out.println();
        return true;
    }

    public static void printPreviousIndexSecondRow(List<String> upOrDown, int index) {
        for (int i = 0; i < index; i++) {
            if (upOrDown.get(i).equals(DOWN)) System.out.print(CORRECT);
            if (upOrDown.get(i).equals(UP)) System.out.print(SPACE);
            System.out.print(DIVIDER);
        }
    }

    public static boolean printCurrentIndexSecondRow(String current, String userInput) {
        if (!(current.equals(userInput)) && current.equals(UP)) {
            System.out.print(WRONG + END);
            System.out.println();
            return false;
        }
        if (!(current.equals(userInput)) && current.equals(DOWN)) System.out.print(SPACE);
        if (current.equals(userInput) && userInput.equals(DOWN)) System.out.print(CORRECT);
        if (current.equals(userInput) && userInput.equals(UP)) System.out.print(SPACE);
        return true;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridgeMaker) {
        System.out.println(FINAL_RESULT);
        startLadder(attempt-1, bridgeMaker, lastUserInput);
        if (!isComplete) System.out.println(SUCCEEDED + FAIL + ATTEMPT + totalCount);
        if (isComplete) System.out.println(SUCCEEDED + SUCCESS + ATTEMPT + totalCount);
    }

    public boolean redoOrQuit(String reset) {
        if (reset.equals(REDO)) {
            isComplete = true;
            attempt = 0;
            return true;
        }
        if (reset.equals(QUIT)) isComplete = false;
        if (!reset.equals(QUIT)) throw new IllegalArgumentException();
        return false;
    }

}
