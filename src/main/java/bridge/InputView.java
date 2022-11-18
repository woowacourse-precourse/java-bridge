package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public static final String NUMERIC_REGEX = "^[1-9]\\d*$";
    public static final String UP_BRIDGE = "U";
    public static final String DOWN_BRIDGE = "D";
    public static final String MOVING_COMMAND_ERROR = "[ERROR] U 또는 D를 입력해 주시기 바랍니다.";
    public static final String RETRY_COMMAND = "R";
    public static final String QUIT_COMMAND = "Q";
    public static final String GAME_COMMAND_ERROR = "[ERROR] R 또는 Q를 입력해 주시기 바랍니다.";
    public static final int START_RANGE = 3;
    public static final int END_RANGE = 20;
    public static final String RANGE_ERROR = "[ERROR] 3에서 20까지의 숫자를 입력해 주시기 바랍니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        System.out.println("다리의 길이를 입력해주세요.");
        String readline = Console.readLine();
        isNumeric(readline);
        isRange(Integer.parseInt(readline));
        return Integer.parseInt(readline);
    }

    private void isRange(int size) {
        if (size < START_RANGE || size > END_RANGE) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }

    private void isNumeric(String readline) {
        if (!Pattern.matches(NUMERIC_REGEX, readline)) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자가 아닙니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String readline = Console.readLine();
        isMovingCommand(readline);
        return readline;
    }

    private void isMovingCommand(String readline) {
        if (!(UP_BRIDGE.equals(readline) || DOWN_BRIDGE.equals(readline))) {
            throw new IllegalArgumentException(MOVING_COMMAND_ERROR);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public boolean readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String readline = Console.readLine();
        isGameCommand(readline);
        return RETRY_COMMAND.equals(readline);
    }

    private void isGameCommand(String readline) {
        if (!(RETRY_COMMAND.equals(readline) || QUIT_COMMAND.equals(readline))) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR);
        }
    }

}
