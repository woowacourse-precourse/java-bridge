package bridge.util;

public class Message {
    public static final String START_GAME = "다리 건너기 게임을 시작합니다.\n";
    public static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    public static final String SELECT_MOVE = "\n이동할 칸을 선택해주주세요. (위: U, 아래: D)";
    public static final String SELECT_RESTART = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String END_GAME = "최종 게임 결과\n";
    public static final String GAME_ATTEMPT_COUT = "총 시도한 횟수: %d";
    public static final String GAME_ERROR_LEN = "[ERROR] 다리 길이는 3부터 20사이의 숫자여야 합니다.";
    public static final String GAME_ERROR_MOVE = "[ERROR] 이동 명령은 U(위 칸) or D(아래 칸) 이여야 합니다.";
    public static final String GAME_ERROR_END = "[ERROR] 게임 종료 명령은 R(재시작) or Q(종료) 이여야 합니다.";
    public static final String RESTART = "R";
    public static final int SELECT_DOWN = 0;
}
