package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String lengthInput = Console.readLine();
        OutputView.printMessage(lengthInput);

        checkIsNumber(lengthInput);
        int length = Integer.valueOf(lengthInput);
        checkRange(length);

        return length;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = Console.readLine();
        OutputView.printMessage(move);
        checkMoving(move);
        return move;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String command = Console.readLine();
        OutputView.printMessage(command);
        checkCommand(command);
        return command;
    }

    private static void checkIsNumber(String lengthInput) {
        try {
            Integer.valueOf(lengthInput);
        } catch (IllegalArgumentException e) {
            String contents = GameMessage
                    .Exception
                    .IS_NUMBER
                    .getContents();
            String message = GameMessage.getErrorMessage(contents);
            OutputView.printMessage(message);
            throw new IllegalArgumentException();
        }
    }

    private static void checkRange(int length) {
        boolean rangeError = !(checkStartRange(length) && checkEndRange(length));

        if (rangeError) {
            String contents = GameMessage
                    .Exception
                    .OUT_OF_RANGE_BRIDGE
                    .getContents();
            String message = GameMessage.getErrorMessage(contents);
            OutputView.printMessage(message);
            throw new IllegalArgumentException();
        }
    }

    private static void checkMoving(String move) {
        boolean moveError = !(checkMatchDown(move) || checkMatchUp(move));

        if (moveError) {
            String contents = GameMessage
                    .Exception
                    .DISALLOWED_INPUT_MOVE
                    .getContents();
            String message = GameMessage.getErrorMessage(contents);
            OutputView.printMessage(message);
            throw new IllegalArgumentException();
        }
    }

    private static void checkCommand(String command) {
        boolean commandError = !(checkMatchRestart(command) || checkMatchQuit(command));

        if (commandError) {
            String contents = GameMessage.Exception.DISALLOWED_INPUT_RE_GAME.getContents();
            String message = GameMessage.getErrorMessage(contents);
            OutputView.printMessage(message);
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkMatchQuit(String command) {
        String quit = BridgeValue
                .Information
                .QUIT
                .getValue();

        if (quit.equals(command)) {
            return true;
        }
        return false;
    }

    private static boolean checkMatchRestart(String command) {
        String restart = BridgeValue
                .Information
                .RE_START
                .getValue();

        if (restart.equals(command)) {
            return true;
        }
        return false;
    }

    private static boolean checkStartRange(int length) {
        String startValue = BridgeValue
                .Information
                .MINIMUM_LENGTH
                .getValue();

        int start = BridgeValue.stringToInt(startValue);
        if (length >= start) {
            return true;
        }
        return false;
    }

    private static boolean checkEndRange(int length) {
        String endValue = BridgeValue
                .Information
                .MAXIMUM_LENGTH
                .getValue();

        int end = BridgeValue.stringToInt(endValue);
        if (length <= end) {
            return true;
        }
        return false;
    }

    private static boolean checkMatchDown(String move) {
        String down = BridgeValue
                .Information
                .DOWN
                .getValue();

        if (down.equals(move)) {
            return true;
        }
        return false;
    }

    private static boolean checkMatchUp(String move) {
        String up = BridgeValue
                .Information
                .UP
                .getValue();

        if (up.equals(move)) {
            return true;
        }
        return false;
    }
}
