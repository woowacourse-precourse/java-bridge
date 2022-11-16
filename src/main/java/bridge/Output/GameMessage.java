package bridge.Output;

import bridge.CommandConstant;

public class GameMessage {
    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String BRIDGE_SIZE_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String MOVE_COMMAND_INPUT_MESSAGE = "이동할 칸을 선택해주세요. "
            + "(위: " + CommandConstant.UP_COMMAND
            + ", 아래: " + CommandConstant.DOWN_COMMAND + ")";
    public static final String GAME_COMMAND_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. "
            + "(재시도: " + CommandConstant.RETRY_COMMAND
            + ", 종료: " + CommandConstant.QUIT_COMMAND + ")";
}
