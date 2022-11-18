package bridge.constant;

public class Game {
    public static final int MIN_SIZE = 3;
    public static final int MAX_SIZE = 20;

    public static final String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_DIRECTION = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RETRY = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    public static final String GAME_SUCCESS = "게임 성공 여부: 성공";
    public static final String GAME_FAILED = "게임 성공 여부: 실패";
    public static final String TOTAL_NUMBER_OF_ATTEMPTS = "총 시도한 횟수: ";
}
