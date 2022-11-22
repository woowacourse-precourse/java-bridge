package bridge.constant;

import static bridge.constant.Rules.MAX_BRIDGE_SIZE;
import static bridge.constant.Rules.MIN_BRIDGE_SIZE;

public class ErrorMessage {

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String WRONG_BRIDGE_SIZE =
            "다리의 길이는 " + MIN_BRIDGE_SIZE + "부터 " + MAX_BRIDGE_SIZE + "사이의 정수여야 합니다.";
    public static final String WRONG_MOVING = "이동할 칸은 U 또는 D여야 합니다.";
    public static final String WRONG_GAME_COMMAND = "게임 재시도 여부는 R 또는 Q여야 합니다.";
}