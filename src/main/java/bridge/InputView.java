package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                String input = Console.readLine();
                return checkBridgeSize(input);
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR] " + exception.getMessage());
            }
        }
    }

    private int checkBridgeSize(String input) {
        int inputNum = checkSizeIsNumber(input);
        checkSizeIsInRange(inputNum);
        checkFirstNumberIsZero(input);
        return inputNum;
    }

    private int checkSizeIsNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("다리의 길이는 숫자로 입력해 주어야 합니다.");
        }
    }

    private void checkSizeIsInRange(int inputNum) {
        if (inputNum < 3 || inputNum > 20) {
            throw new IllegalArgumentException("다리의 길이는 3에서 20 사이의 숫자입니다.");
        }
    }

    private void checkFirstNumberIsZero(String input) {
        if (input.charAt(0) == '0') {
            throw new IllegalArgumentException("0으로 시작하는 숫자는 옳은 입력방식이 아닙니다.");
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                String input = Console.readLine();
                checkMoveCommand(input);
                return input;
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR] " + exception.getMessage());
            }
        }
    }

    private void checkMoveCommand(String input) {
        if (!Objects.equals(input, "U") && !Objects.equals(input, "D")) {
            throw new IllegalArgumentException("U 또는 D를 입력해주세요");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                String input = Console.readLine();
                checkGameCommand(input);
                return input;
            } catch (IllegalArgumentException exception) {
                System.out.println("[ERROR] " + exception.getMessage());
            }
        }
    }

    private void checkGameCommand(String input) {
        if (!Objects.equals(input, "R") && !Objects.equals(input, "Q")) {
            throw new IllegalArgumentException("R 또는 Q를 입력해주세요");
        }
    }
}
