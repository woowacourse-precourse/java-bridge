package bridge;

public class Message {

    public static final String ERROR = "[ERROR] ";
    public static final String INVALID_MOVE_INPUT = "이동할 칸은 U 또는 D 이어야합니다.";
    public static final String INVALID_RETRY_INPUT = "게임 재시도 여부는 R 또는 Q 이어야합니다.";
    public static final String INVALID_BRIDGE_SIZE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String INVALID_RANDOM_NUMBER = "다리 생성 숫자는 0 또는 1이어야 합니다.";

    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다." + System.lineSeparator();
    public static final String BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요. (위: U, 아래: D)" + System.lineSeparator();
    public static final String MOVE_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)" + System.lineSeparator();
    public static final String RETRY_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)" + System.lineSeparator();
    public static final String GAME_RESULT = "게임 성공 여부: %s" + System.lineSeparator() + "총 시도한 횟수: %d" + System.lineSeparator();

}
