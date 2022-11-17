package bridge;

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
    static InputView iv = new InputView();

    static int count = 1;

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean printMap(int index, List<String> upOrDown, String userInput) {
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
    public boolean printResult(List<String> bridgeMaker) {
        String reset;
        for (int i = 0; i < bridgeMaker.size(); i++) {
            String userInput = iv.readMoving();
            if (!printMap(i, bridgeMaker, userInput)) {
                reset = iv.readGameCommand();
                return retry(bridgeMaker, reset);
            }
        }
        return false;
    }

    public boolean retry(List<String> bridgeMaker, String reset) {
        if (reset.equals(REDO)) return true;
        if (reset.equals(QUIT)) return false;

        throw new IllegalArgumentException();
    }

    public void gameEnded(List<String> bridgeMaker) {
        System.out.println("최종 게임 결과!");
//        printMap(bridgeMaker.size()-1, bridgeMaker, userInput);
//        System.out.println("게임 성공 여부: 성공\n" +
//                "총 시도한 횟수: 2");
    }

}
