package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import static bridge.constants.Constants.*;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("\n" + ENTER_BRIDGE_LENGTH_MESSAGE);
        String bridgeLength = Console.readLine();
        return validateBridgeSize(bridgeLength);
    }

    //숫자이고 가능한 길이 인지 확인한다.
    public int validateBridgeSize(String bridgeLength) {
        int bridgeLen = StringToInteger(bridgeLength);
        if (GAME_SETTING_BRIDGE_RANGE_START <= bridgeLen && bridgeLen <= GAME_SETTING_BRIDGE_RANGE_END) {
            return bridgeLen;
        }
        throw new IllegalArgumentException(ERROR_BRIDGE_LENGTH_RANGE);
    }

    private int StringToInteger(String bridgeLength) {
        try {
            return Integer.parseInt(bridgeLength);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_BRIDGE_LENGTH_NOT_NUMBER);
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("\n" + ENTER_MOVING_MESSAGE);
        String wantedDirection = Console.readLine();
        return validateMoving(wantedDirection);
    }

    private String validateMoving(String wantMoved) {
        if (wantMoved.equals(GAME_COMMAND_UP) || wantMoved.equals(GAME_COMMAND_DOWN)) {
            return wantMoved;
        }
        throw new IllegalArgumentException(ERROR_MOVING_INPUT);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("\n" + ENTER_GAME_COMMAND_MESSAGE);
        String wantRetrying = Console.readLine();
        return validateGameCommand(wantRetrying);
    }

    private String validateGameCommand(String wantRetrying) {
        if (wantRetrying.equals(GAME_COMMAND_RETRY) || wantRetrying.equals(GAME_COMMAND_QUIT)) {
            return wantRetrying;
        }
        throw new IllegalArgumentException(ERROR_RETRYING_INPUT);
    }
}
