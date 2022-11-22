package bridge.constant;

import static bridge.Moving.DOWN;
import static bridge.Moving.UP;
import static bridge.constant.GameCommand.QUIT;
import static bridge.constant.GameCommand.RETRY;

public class Message {

    public static final String GAME_START = "다리 건너기 게임을 시작합니다.\n";
    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING =
            "이동할 칸을 선택해주세요. (위: " + UP.getCode() + ", 아래: " + DOWN.getCode() + ")";
    public static final String INPUT_GAME_COMMAND =
            "게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + RETRY + ", 종료: " + QUIT + ")";
    public static final String GAME_RESULT = "최종 게임 결과";
    public static final String GAME_SUCCESS = "게임 성공 여부: ";
    public static final String SUCCESS = "성공";
    public static final String FAIL = "실패";
    public static final String TOTAL_TRIAL_COUNT = "총 시도한 횟수: ";
}
