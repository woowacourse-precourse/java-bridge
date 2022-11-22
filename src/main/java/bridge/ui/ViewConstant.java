package bridge.ui;

public class ViewConstant {
    public static final String LINE_FEED = "\n";

    // InputView
    public static final String INPUT_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RESTART_WHETHER_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    // OutView
    public static final String GAME_INIT_MESSAGE = "다리 건너기 게임을 시작합니다." + LINE_FEED;
    public static final String GAME_SUCCESS_WHETHER_MESSAGE = "게임 성공 여부: ";
    public static final String GAME_COUNT_MESSAGE = "총 시도한 횟수: ";
    public static final String GAME_RESULT_MESSAGE = "최종 게임 결과";

    // Bridge
    public static final String START_BRIDGE_SHAPE = "[";
    public static final String END_BRIDGE_SHAPE = "]" + LINE_FEED;
    public static final String JOINING_DELIMITER = "|";
}
