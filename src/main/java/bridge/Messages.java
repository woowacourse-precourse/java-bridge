package bridge;

public class Messages {
    public static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    public static final String BRIDGE_LENGTH_QUESTION = "다리의 길이를 입력해주세요.";
    public static final String MOVING_SELECTION_QUESTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String GAME_COMMAND_SELECTION_QUESTION = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String FINAL_RESULT_HEADER = "최종 게임 결과";
    public static final String FINAL_RESULT_GAME_STATE_PREFIX = "게임 성공 여부: ";
    public static final String FINAL_RESULT_TRY_PREFIX = "총 시도한 횟수: ";
    public static final String INVALID_BRIDGE_LENGTH_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String INVALID_MOVING_INPUT_ERROR = "[ERROR] 위 칸으로 이동하려면 U를, 아래 칸으로 이동하려면 D를 입력해주세요.";
    public static final String INVALID_GAME_COMMAND_INPUT_ERROR  = "[ERROR] 재시도를 하려면 R을, 종료하려면 Q를 선택해주세요.";
}
