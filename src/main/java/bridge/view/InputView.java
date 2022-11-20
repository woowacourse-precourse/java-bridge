package bridge.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    private static final String ERROR = "[ERROR] ";
    private static final String MOVING_ERROR = ERROR + UP + " 또는 " + DOWN + "를 입력해주세요.";
    private static final String COMMAND_ERROR = ERROR + RESTART + " 또는 " + QUIT + "를 입력해주세요.";
    private static final String NUMBER_FORMAT_ERROR = ERROR + "숫자를 입력해주세요.";

    public int readBridgeSize() {
        return checkNumberFormat(input());
    }

    public String readMoving() {
        while (true) {
            try {
                return checkMoving(input());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String readGameCommand() {
        while (true) {
            try {
                return checkCommand(input());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String checkCommand(String command) {
        if (isWrongCommand(command)) {
            throw new IllegalArgumentException(COMMAND_ERROR);
        }
        return command;
    }

    private boolean isWrongCommand(String command) {
        return !(command.equals(RESTART) || command.equals(QUIT));
    }

    private String checkMoving(String moving) {
        if (isWrongMoving(moving)) {
            throw new IllegalArgumentException(MOVING_ERROR);
        }
        return moving;
    }

    private boolean isWrongMoving(String moving) {
        return !(moving.equals(UP) || moving.equals(DOWN));
    }

    private int checkNumberFormat(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR);
        }
    }

    private String input() {
        return Console.readLine();
    }
}
