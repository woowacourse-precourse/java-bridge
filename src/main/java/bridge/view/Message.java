package bridge.view;

import bridge.model.BridgeSize;
import bridge.model.GameCommand;
import bridge.model.Moving;

public final class Message {
    public static final String ERROR = "[ERROR] ";
    public static final String BRIDGE_SIZE_INPUT = "\n다리의 길이를 입력해주세요.";
    public static final String BRIDGE_SIZE_ERROR = "다리 길이는 " + BridgeSize.LOWER_BRIDGE_SIZE + "부터 " + BridgeSize.UPPER_BRIDGE_SIZE + " 사이의 숫자여야 합니다.";
    public static final String MOVE_INPUT = "\n이동할 칸을 선택해주세요. (위: " + Moving.UP.getValue() + ", 아래: " + Moving.DOWN.getValue() + ")";
    public static final String MOVE_ERROR = "이동할 칸은 " + Moving.UP.getValue() + "나 " + Moving.DOWN.getValue() + "로만 입력해주세요.";
    public static final String GAME_COMMAND_INPUT = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + GameCommand.RE_GAME.getValue() + ", 종료: " + GameCommand.QUIT.getValue() + ")";
    public static final String GAME_COMMAND_ERROR = "게임 재시도 여부는 " + GameCommand.RE_GAME.getValue() + "이나 " + GameCommand.QUIT.getValue() + "로만 입력해주세요.";
    public static final String MAP_START = "[ ";
    public static final String MAP_MIDDLE = " | ";
    public static final String MAP_END = " ]";


}
