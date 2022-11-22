package bridge.Constant;

public class Message {
    public static final String MSG_START = "다리 건너기 게임을 시작합니다.";
    public static final String MSG_GET_LENGTH = "다리의 길이를 입력해 주세요.";
    public static final String MSG_GET_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String MSG_GET_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String MSG_END = "최종 게임 결과";
    public static final String MSG_END_SUCCESS = "게임 성공 여부: ";
    public static final String MSG_END_TRY = "총 시도한 횟수: ";

    public static final String ERROR_INT = "[ERROR] 다리 길이는 숫자여야 합니다. 다시 입력해 주세요.";
    public static final String ERROR_LENGTH = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다. 다시 입력해 주세요.";
    public static final String ERROR_MOVE = "[ERROR] 입력은 U 혹은 D여야 합니다. 다시 입력해 주세요. (위: U, 아래: D)";
    public static final String ERROR_RETRY = "[ERROR] 입력은 R 혹은 Q여야 합니다. 다시 입력해 주세요. (재시도: R, 종료: Q)";
}
