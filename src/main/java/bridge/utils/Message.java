package bridge.utils;

public class Message {
    public static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    public static final String INPUT_LENGTH = "다리의 길이를 입력해주세요.";
    public static final String SELECT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String SELECT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String PRINT_GAME_RESULT = "최종 게임 결과";
    public static final String PRINT_GAME_IS_SUCCESS = "게임 성공 여부";
    public static final String PRINT_ATTEMPTS = "총 시도한 횟수";
    public static final String ERROR_MESSAGE = "[ERROR] %s";

    public static String createErrorMessage(String errorMessage){
        return String.format(ERROR_MESSAGE, errorMessage);
    }
}
