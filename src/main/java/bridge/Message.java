package bridge;

public class Message {
    //region Application
    public static final String GAME_START_COMMENT = "다리 건너기 게임을 시작합니다.";
    //endregion

    //region InputView
    public static final String BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String ERROR_SMALL_SIZE = "다리의 길이는 3보다 작을 수 없습니다.";
    public static final String ERROR_BIG_SIZE = "다리의 길이는 20보다 클 수 없습니다.";
    public static final String ERROR_NOT_NUMBER = "다리의 길이는 숫자로 작성해주셔야 합니다.";
    public static final String ERROR_UP_AND_DOWN = "이동 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자를 입력하셔야 합니다.";
    public static final String ERROR_RETRY_AND_QUIT = "게임 재시도는 R(재시도)와 Q(종료) 중 하나의 문자를 입력하셔야 합니다.";
    //endregion

    //region OutputView
    public static final String GAME_FINAL_RESULT = "최종 게임 결과";
    public static final String TOTAL_TRY_COUNT = "총 시도한 횟수 : %d";
    public static final String GAME_SUCCESS = "게임 성공 여부: 성공";
    public static final String GAME_FAIL = "게임 성공 여부: 실패";
    public static final String ERROR = "[ERROR]";
    //endregion
}
