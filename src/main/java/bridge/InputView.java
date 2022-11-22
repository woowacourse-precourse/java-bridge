package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    public static final int MIN_BRIDGE_SIZE_RANGE = 3;
    public static final int MAX_BRIDGE_SIZE_RANGE = 20;
    public static final String RESTART = "R";
    public static final String QUIT = "Q";

    private static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_PLAYER_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RESTART_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    private static final String ERR_BRIDGE_SIZE_IS_NUMBER = "[ERROR] 다리의 길이는 숫자여야 합니다.";
    private static final String ERR_BRIDGE_SIZE_RANGE = "[ERROR] 다리의 길이는 최소 3이상 최대 20이하입니다.";
    private static final String ERR_MOVING_COMMAND_IS_U_OR_D = "[ERROR] 이동할 칸은 U 또는 D를 입력해야합니다.";
    private static final String ERR_RESTART_COMMAND_IS_R_OR_Q = "[ERROR] 게임의 재시도 여부는 R 또는 Q를 입력해야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        do {
            System.out.println(INPUT_BRIDGE_SIZE);
            try {
                return validateBridgeSize(convertStringToInt(Console.readLine()));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        do {
            System.out.println(INPUT_PLAYER_MOVING);
            try {
                return validateUpOrDown(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        do {
            System.out.println(INPUT_RESTART_OR_QUIT);
            try {
                return validateRestartOrQuit(Console.readLine());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }
    
    private int validateBridgeSize(int bridgeSize) {
        if (bridgeSize < MIN_BRIDGE_SIZE_RANGE || MAX_BRIDGE_SIZE_RANGE < bridgeSize) {
            throw new IllegalArgumentException(ERR_BRIDGE_SIZE_RANGE);
        }
        return bridgeSize;
    }

    private String validateUpOrDown(String moving) {
        if (UpAndDown.isUpOrDown(moving)) {
            return moving;
        }
        throw new IllegalArgumentException(ERR_MOVING_COMMAND_IS_U_OR_D);
    }

    private String validateRestartOrQuit(String command) {
        if (List.of(RESTART,QUIT).contains(command)) {
            return command;
        }
        throw new IllegalArgumentException(ERR_RESTART_COMMAND_IS_R_OR_Q);
    }

    private int convertStringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERR_BRIDGE_SIZE_IS_NUMBER);
        }
    }
}
