package bridge.view;

import bridge.exception.Exception;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String enterBridgeSize = "다리의 길이를 입력해주세요.";
    private static final String enterBridgeCourse = "이동할 칸을 입력해주세요. (위: U, 아래: D)";
    private static final String enterRestartOrQuit = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(enterBridgeSize);
        String input = Console.readLine();
        isNumber(input);
        return Integer.parseInt(input);
    }

    private void isNumber(String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw Exception.IS_NOT_NUMBER_EXCEPTION.getException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(enterBridgeCourse);
        String input = Console.readLine();
        validateLength(input);
        isLetter(input);
        isCourse(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(enterRestartOrQuit);
        String input = Console.readLine();
        validateLength(input);
        isLetter(input);
        isRestartFlag(input);
        return input;
    }


    private void validateLength(String input) {
        if (input.length() != 1) {
            throw Exception.WRONG_LENGTH_EXCEPTION.getException();
        }
    }

    private void isLetter(String input) {
        if (!Character.isLetter(input.charAt(0))) {
            throw Exception.IS_NOT_LETTER_EXCEPTION.getException();
        }
    }

    private void isCourse(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw Exception.IS_NOT_COURSE_EXCEPTION.getException();
        }
    }

    private void isRestartFlag(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw Exception.IS_NOT_FLAG_EXCEPTION.getException();
        }
    }
}
