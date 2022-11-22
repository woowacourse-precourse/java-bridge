package bridge.util;

import java.util.regex.Pattern;

import static bridge.constant.BridgeMove.*;
import static bridge.constant.BridgeRange.*;
import static bridge.constant.BridgeControl.*;
import static bridge.constant.message.ExceptionMessage.*;

public class ValidationUtil {

    /**
     * 사용자가 입력한 다리의 길이에 대해 검증을 진행한다.
     *
     * @param input 사용자의 입력값
     * @return 검증된 다리의 길이
     */
    public int validateBridgeLength(String input) {
        checkNumberType(input);
        int bridgeLength = Integer.parseInt(input);
        checkNumberRange(bridgeLength);
        return bridgeLength;
    }

    /**
     * 사용자가 입력한 이동할 칸이 U 혹은 D인지 검증한다.
     *
     * @param input 사용자의 입력값
     * @return 검증된 사용자의 이동 예정 칸
     */
    public String validatePlayerMoveInput(String input) {
        if (input.equals(UP.getIdentifier()) || input.equals(DOWN.getIdentifier())) {
            return input;
        }

        throw new IllegalArgumentException(String.format(PLAYER_MOVE.getMessage(),
                UP.getIdentifier(), DOWN.getIdentifier()));
    }

    /**
     * 사용자가 입력한 재시작/종료 여부가 R 혹은 Q인지 검증한다.
     *
     * @param input 사용자의 입력값
     * @return 검증된 사용자의 재시작/종료 여부
     */
    public String validatePlayControlInput(String input) {
        if (input.equals(RESTART.getIdentifier()) || input.equals(QUIT.getIdentifier())) {
            return input;
        }

        throw new IllegalArgumentException(String.format(PLAY_CONTROL.getMessage(),
                RESTART.getIdentifier(), QUIT.getIdentifier()));
    }

    private void checkNumberType(String input) {
        String regex = "[0-9]+";

        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(BRIDGE_LENGTH_TYPE.getMessage());
        }
    }

    private void checkNumberRange(int input) {
        if (input < MIN_LENGTH.getNumber() || input > MAX_LENGTH.getNumber()) {
            throw new IllegalArgumentException(String.format(BRIDGE_LENGTH_RANGE.getMessage(),
                    MIN_LENGTH.getNumber(), MAX_LENGTH.getNumber()));
        }
    }
}
