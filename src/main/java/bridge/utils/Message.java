package bridge.utils;

public class Message {
    public static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    public static final String INPUT_LENGTH = "다리의 길이를 입력해주세요.";
    public static final String SELECT_MOVE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String SELECT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String PRINT_TOTAL_RESULT = "최종 게임 결과";
    private static final String GAME_RESULT = "게임 성공 여부: %s";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String TOTAL_ATTEMPTS = "총 시도한 횟수: %d";
    public static final String ERROR_MESSAGE = "[ERROR] %s";

    public static String createErrorMessage(String errorMessage){
        return String.format(ERROR_MESSAGE, errorMessage);
    }

    public static String getGameResult(boolean success) {
        if (success) {
            return String.format(GAME_RESULT, SUCCESS);
        }
        return String.format(GAME_RESULT, FAIL);
    }

    public static String getAttempts(int attempts) {
        return String.format(TOTAL_ATTEMPTS, attempts);
    }
}
