package bridge.domain.util;

public class Message {
    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다. \n";
    public static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String COUNT_MESSAGE = "총 시도한 횟수: ";
    public static final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String RESULT_MESSAGE = "최종 게임 결과";
    public static final String SUCCESS_MESSAGE = "게임 성공 여부: 성공";
    public static final String FAIL_MESSAGE = "게임 성공 여부: 실패";
    public static final String BRIDGE_SIZE_ERROR_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String MOVE_ERROR_MESSAGE = "이동할 칸은 U 또는 D여야 합니다.";
    public static final String RETRY_ERROR_MESSAGE = "재시작은 R 또는 Q여야 합니다.";
    public static final String ERROR_MESSAGE = "[ERROR] ";
}
