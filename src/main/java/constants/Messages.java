package constants;

public class Messages {

    // InputView
    public static final String ENTER_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    public static final String ENTER_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String ENTER_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static final String NOT_IN_RANGE = "[ERROR] 3 이상 20 이하의 숫자를 입력하여야 합니다.";
    public static final String NOT_MOVING_COMMAND = "[ERROR] U 와 D 중 하나의 문자를 입력하여야 합니다.";
    public static final String NOT_GAME_COMMAND = "[ERROR] R 와 Q 중 하나의 문자를 입력하여야 합니다.";

    // OutputView
    public static final String SHOW_GAME_RESERT = "\n최종 게임 결과";
    public static final String SUCCESS_GAME = "게임 성공 여부: 성공";
    public static final String FAIL_GAME = "게임 성공 여부: 실패";
    public static final String TOTAL_TRIES = "총 시도한 횟수: ";

    //GameManager
    public static final String BRIDGE_GAME_START = "다리 건너기 게임을 시작합니다.";
}
