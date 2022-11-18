package bridge;

public class Message {
    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String IS_GAME_SUCCESSFUL = "게임 성공 여부: ";
    public static final String TOTAL_NUMBER_OF_ATTEMPTS = "총 시도한 횟수: ";
    public static final String INPUT_MOVE_U_OR_D = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_GAME_RETRY_OR_EXIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String RESULT_MESSAGE = "최종 게임 결과";

    public static final String INPUT_IS_NOT_NUMBER = "[ERROR] 숫자만 입력해주세요.";
    public static final String INPUT_CORRECT_RANGE_OF_NUMBER = "[ERROR] 3~20 사이의 숫자를 입력해주세요.";
    public static final String INPUT_U_OR_D = "[ERROR] U와 D 이외의 다른것이 입력되었습니다.";
    public static final String INPUT_R_OR_Q = "[ERROR] R과 Q 이외의 다른것이 입력되었습니다.";

    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;
}
