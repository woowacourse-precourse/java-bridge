package bridge.constant;

import static bridge.Moving.DOWN;
import static bridge.Moving.UP;
import static bridge.constant.GameCommand.QUIT;
import static bridge.constant.GameCommand.RETRY;
import static bridge.constant.Rules.MAX_BRIDGE_SIZE;
import static bridge.constant.Rules.MIN_BRIDGE_SIZE;

public class ErrorMessage {

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String WRONG_BRIDGE_SIZE =
            "다리의 길이는 " + MIN_BRIDGE_SIZE + "부터 " + MAX_BRIDGE_SIZE + "사이의 정수여야 합니다.";
    public static final String WRONG_MOVING =
            "이동할 칸은 " + UP.getCode() + " 또는 " + DOWN.getCode() + "여야 합니다.";
    public static final String WRONG_GAME_COMMAND =
            "게임 재시도 여부는 " + RETRY + " 또는 " + QUIT + "여야 합니다.";
}