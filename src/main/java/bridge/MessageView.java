package bridge;

public class MessageView {
    /** GAME MESSAGE **/
    public static final String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RETRY_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    public static final String GAME_SUCCESS = "게임 성공 여부: 성공";
    public static final String GAME_FAILED = "게임 성공 여부: 실패";
    public static final String TOTAL_ATTEMPTS = "총 시도한 횟수: ";

    /** ERROR MESSAGE **/
    public static final String INVALID_INPUT_NUMBER = "숫자를 입력해주세요.";
    public static final String INVALID_RANGE = "다리 길이는 3 이상 20 이하의 숫자여야 합니다.";
    public static final String INVALID_DIRECTION = "U(위 칸)이나 D(아래 칸)으로만 이동 가능합니다.";
    public static final String INVALID_COMMAND = "R(재시도)이나 Q(종료)를 입력해주세요.";
}
