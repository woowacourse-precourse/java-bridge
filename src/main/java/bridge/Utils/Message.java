package bridge.Utils;

public class Message {

    public static final String WRONG = "X";
    public static final String CORRECT = "O";
    public static final String PASS = " ";

    //input
    public static final String BRIDGE_LENTH_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    public static final String BRIDGE_MOVE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public static final String GAME_REPLAY_INPUT_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    //output
    public static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";

    public static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";

    public static final String FINAL_GAME_STATUS_MESSAGE = "게임 성공 여부: ";

    public static final String FINAL_ROUND_COUNT_MESSAGE = "총 시도한 횟수: ";


    //EROOR
    public static final String BRIDGE_LENTH_NUM_ERROR = "[ERROR] 다리의 길이가 숫자가 아닙니다.";
    public static final String BRIDGE_LENGTH_RANGE_ERROR = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String BRIDGE_MOVE_INPUT_ERROR = "[ERROR] 이동칸 선택(U/D) 입력이 잘못되었습니다.";
    public static final String GAME_REPLAY_INPUT_ERROR = "[ERROR] 재시작 여부에 대한 입력이 잘못되었습니다.";


}
