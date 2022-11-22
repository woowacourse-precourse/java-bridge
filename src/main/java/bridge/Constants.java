package bridge;

public class Constants {
    public static final String UP_BRIDGE = "U";
    public static final String DOWN_BRIDGE = "D";
    public static final String RESTART_GAME = "R";
    public static final String QUIT_GAME = "Q";
    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    public static final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_POSITION_MESSAGE =
            "\n이동할 칸을 선택해주세요. (위: " + UP_BRIDGE + ", 아래: " + DOWN_BRIDGE + ")";
    public static final String INPUT_COMMAND_MESSAGE =
            "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: " + RESTART_GAME + ", 종료: " + QUIT_GAME + ")";
    public static final String FINAL_MESSAGE = "\n최종 게임 결과";
    public static final String COMPLETE_OR_NOT = "\n게임 성공 여부: ";
    public static final String ATTEMPTS_NUMBER = "총 시도한 횟수: ";
    public static final String PASS_MESSAGE = " O ";
    public static final String FAIL_MESSAGE = " X ";
    public static final String COMPLETE = "성공";
    public static final String FAIL = "실패";
    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;
}
