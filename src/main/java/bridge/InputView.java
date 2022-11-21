package bridge;

import camp.nextstep.edu.missionutils.Console;
import console.ErrorMessage;
import console.InputMessage;
import console.OutputMessage;
import console.BridgeGameMessage;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    static final int UPPER_BOUND = 20;
    static final int LOWER_BOUND = 3;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(InputMessage.OPEN_STATEMENT.getMessage());
        System.out.println(InputMessage.ENTER_BRIDGE_LENGTH.getMessage());
        return catchException();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(InputMessage.MOVE.getMessage());
        String input = Console.readLine();
        try {
            upOrDownCheck(input);
        } catch (IllegalArgumentException err) {
            System.out.println(err.getMessage());
            readMoving();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(InputMessage.RETRY.getMessage());
        String redoOrQuit = "";
        try {
            redoOrQuit = Console.readLine();
            redoOrQuitCheck(redoOrQuit);
        } catch (IllegalArgumentException err) {
            System.out.println(err.getMessage());
            return readGameCommand();
        }
        return redoOrQuit;
    }

    public static int catchException() {
        String read = Console.readLine();
        int input;
        try {
            input = isNumeric(read);
            rangeCheck(input);
        } catch (IllegalArgumentException argException) {
            System.out.println(argException.getMessage());
            return catchException();
        }
        return input;
    }

    public static void rangeCheck(int number) {
        if ((number < LOWER_BOUND || number > UPPER_BOUND)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER.getMessage());
        }
    }

    public static int isNumeric(String input) {
        int convertInt;
        try {
            convertInt = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_STRING.getMessage());
        }
        return convertInt;
    }

    public static void upOrDownCheck(String move) {
        if (!(move.equals(OutputMessage.UP.getMessage()) || move.equals(OutputMessage.DOWN.getMessage())))
            throw new IllegalArgumentException(ErrorMessage.ERROR_UP_DOWN.getMessage());
    }

    public static void redoOrQuitCheck(String move) {
        if (!(move.equals(BridgeGameMessage.REDO.getMessage()) || move.equals(BridgeGameMessage.QUIT.getMessage())))
            throw new IllegalArgumentException(ErrorMessage.ERROR_RETRY.getMessage());
    }

}
