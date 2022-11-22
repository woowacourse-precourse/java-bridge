package view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public InputView() {
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int size = 0;
        String input = "";

        while (size == 0) {
            input = Console.readLine();
            size = validateSize(input);
            size = validateRange(3, 20, size);
        }
        return size;
    }

    private int validateSize(String input) {
        try {
            int size = Integer.parseInt(input);
            return size;
        } catch (NumberFormatException e) {
            System.out.println(new IllegalArgumentException("[ERROR] Only numbers allowed"));
            return 0;
        }
    }

    private int validateRange(int start, int end, int value) {
        if (value < start || value > end) {
            System.out.println(new IllegalArgumentException("[ERROR] Numbers should be in the range of "
                    + start + "~" + end));
            return 0;
        }
        return value;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        boolean isValid = false;
        String input = "";

        while (!isValid) {
            input = Console.readLine();
            isValid = validateReadMoving(input);
        }
        return input;
    }

    private boolean validateReadMoving(String input) {
        if (input.length() != 1) {
            System.out.println(new IllegalArgumentException("[ERROR] Input should either be U or D"));
            return false;
        }
        if (!input.equals("U") && !input.equals("D")) {
            System.out.println(new IllegalArgumentException("[ERROR] Input should either be U or D"));
            return false;
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        boolean isValid = false;
        String input = "";

        while (!isValid) {
            input = Console.readLine();
            isValid = validateGameCommand(input);
        }

        return input;
    }

    private boolean validateGameCommand(String input) {
        if (input.length() != 1) {
            System.out.println(new IllegalArgumentException("[ERROR] Input should either be R or Q"));
            return false;
        }
        if (!input.equals("R") && !input.equals("Q")) {
            System.out.println(new IllegalArgumentException("[ERROR] Input should either be R or Q"));
            return false;
        }
        return true;
    }
}
