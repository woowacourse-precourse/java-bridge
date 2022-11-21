package bridge;

public class Message {

    public static final String WRONG = "X";
    public static final String CORRECT = "O";
    public static final String PASS = " ";
    //input
    static final String BRIDGE_LENTH_INPUT_MESSAGE = "다리의 길이를 입력해주세요.";
    static final String BRIDGE_MOVE_INPUT_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    static final String GAME_REPLAY_INPUT_MESSAGE = "게임을 다시 시도할 지 여부를 입력해주세요. (재시도: R, 종료: Q)";


    //output
    static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";


    //EROOR
    static final String NONE_INPUT_ERROR = "[ERROR] 입력값이 없습니다. 값을 입력해주세요.";
    static final String BRIDGE_LENTH_NUM_ERROR = "[ERROR] 다리의 길이가 숫자가 아닙니다.";
    static final String BRIDGE_LENGTH_RANGE_ERROR = "[ERROR] 다리 길이는 3~20이어야 합니다.";
    static final String BRIDGE_MOVE_INPUT_ERROR = "[ERROR] 이동칸 선택(U/D) 입력이 잘못되었습니다.";
    static final String GAME_REPLAY_INPUT_ERROR ="[ERROR] 재시작 여부에 대한 입력이 잘못되었습니다.";



}
