package view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다. InputView 클래스에서만 camp.nextstep.edu.missionutils.Console 의 readLine()을 이용해 사용자의 입력을 받을 수 있다.
 * InputView의 패키지는 변경할 수 있다. InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 */
public class InputView {

    public static final char UPPER_START = 'A';
    public static final char UPPER_END = 'Z';
    public static final char LOWER_START = 'a';
    public static final char LOWER_END = 'z';

    public int readBridgeSize() {
        String size = Console.readLine();
        checkNumberValidity(size);
        return Integer.parseInt(size);
    }

    private void checkNumberValidity(String size) throws IllegalArgumentException {
        if (size.length() != 1) {
            throw new IllegalArgumentException();
        }
        char validLengthSize = size.charAt(0);
        if (Character.isDigit(validLengthSize) == false) {
            throw new IllegalArgumentException();
        }
    }

    public String readMoving() {
        String move = Console.readLine();
        CheckAlphabetValidity(move);
        return move;
    }

    public String readGameCommand() {
        String command = Console.readLine();
        CheckAlphabetValidity(command);
        return null;
    }

    private void CheckAlphabetValidity(String input) throws IllegalArgumentException {
        if (input.length() != 1) {
            throw new IllegalArgumentException();
        }
        char validLengthInput = input.charAt(0);
        if (!(validLengthInput >= UPPER_START && validLengthInput <= UPPER_END)
                && !(validLengthInput >= LOWER_START && validLengthInput <= LOWER_END)) {
            throw new IllegalArgumentException();
        }
    }
}
