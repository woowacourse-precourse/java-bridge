package bridge.utils;

public class ViewMessage {
    public static final String GAME_START = "다리 건너기 게임을 시작합니다.%n";

    public static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_GAME_COMMAND = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static final String OUTPUT_FINAL_RESULT = "\n최종 게임 결과";
    public static final String OUTPUT_GAME_SUCCESS = "\n게임 성공 여부: 성공";
    public static final String OUTPUT_GAME_FAIL = "\n게임 성공 여부: 실패";
    public static final String OUTPUT_NUMBER_OF_ATTEMPTS = "총 시도한 횟수: %d";

    public static final String START_OF_BRIDGE = "[ ";
    public static final String END_OF_BRIDGE = " ]";
    public static final String SEPARATOR_OF_BRIDGE = " | ";
}
