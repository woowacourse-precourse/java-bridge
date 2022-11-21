package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    public static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String MOVING_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    private void printBridgeSizeMessage() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println(BRIDGE_SIZE_INPUT_MESSAGE);
    }

    private int readNumber() throws IllegalArgumentException {
        String inputNumber = Console.readLine();
        System.out.println();
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private int readValidRangeNumber() throws IllegalArgumentException {
        int number = readNumber();

        if (number < 3 || number > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return number;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                printBridgeSizeMessage();
                return readValidRangeNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String readMovingCommand() throws IllegalArgumentException {
        String inputCommand = Console.readLine();

        if (!(inputCommand.equals("U") || inputCommand.equals("D")))
            throw new IllegalArgumentException("[ERROR] 올바른 알파벳을 입력해주세요. (위: U, 아래: D)");
        return inputCommand;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                System.out.println(MOVING_INPUT_MESSAGE);
                return readMovingCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
