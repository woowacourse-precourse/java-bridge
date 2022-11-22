package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public enum Data {
        BRIDGE_SIZE("^[3-9]{1}$|^[1]{1}[0-9]{1}$|^20$",
                "다리의 길이를 입력해주세요.",
                "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
        MOVING("^U{1}$|^D{1}$",
                "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                "[ERROR] U 또는 D를 입력해야 합니다."),
        GAME_COMMAND("^R{1}$|^Q{1}$",
                "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                "[ERROR] R 또는 Q를 입력해야 합니다.");

        private String pattern;
        private String start_message;
        private String error_message;

        private Data(String pattern, String start_message, String error_message) {
            this.pattern = pattern;
            this.start_message = start_message;
            this.error_message = error_message;
        }
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Data.BRIDGE_SIZE.start_message);
        String input = Console.readLine();
        return validateBridgeSize(input);
    }

    private int validateBridgeSize(String input) {
        try {
            if (!input.matches(Data.BRIDGE_SIZE.pattern))
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(Data.BRIDGE_SIZE.error_message);
            readBridgeSize();
        }
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Data.MOVING.start_message);
        String input = Console.readLine();
        validateMoving(input);
        return input;
    }

    private void validateMoving(String input) {
        try {
            if (!input.matches(Data.MOVING.pattern))
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(Data.MOVING.error_message);
            readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Data.GAME_COMMAND.start_message);
        String input = Console.readLine();
        validateGameCommand(input);
        return input;
    }

    private void validateGameCommand(String input) {
        try {
            if (!input.matches(Data.GAME_COMMAND.pattern))
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(Data.GAME_COMMAND.error_message);
            readGameCommand();
        }
    }
}
