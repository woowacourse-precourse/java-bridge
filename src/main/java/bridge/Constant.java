package bridge;

public class Constant {
    public static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    public static final String SELECT_LOCATION = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String SELECT_RETRY = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String INPUT_LENGTH = "\n다리의 길이를 입력해주세요.";

    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String ERROR_BRIDGE_LENGTH = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String ERROR_MOVE = "이동 관련 입력은 U와 D만 사용 가능합니다.";
    public static final String ERROR_RETRY = "게임 종료 및 재시작 관련 입력은 R와 Q만 사용 가능합니다.";
    
    public static final String RESULT_OF_GAME = "\n최종 게임 결과";
    public static final String TOTAL_TRY = "총 시도한 횟수: ";
    public static final String RESULT_OF_TRY = "\n게임 성공 여부: ";
    public static final String NUM_REGEX = "[1-9][0-9]*";
    public static final String FRONT = "[ ";
    public static final String BACK = "]";
    public static final String DELIMITER = "| ";

    public static final String WIN = "성공";
    public static final String LOSE = "실패";

    public static final String DOWN = "D";
    public static final String UP = "U";

    public static final String RESTART = "R";
    public static final String QUIT = "Q";

    public static final String SUCCESS = "O";
    public static final String FAIL = "X";
    public static final String SPACE = " ";

    public static String Select_Move(){
        return SELECT_LOCATION;
    }

    public static String Select_Replay(){
        return SELECT_RETRY;
    }

    public static String Length_Restrict(){
        return ERROR_MESSAGE + ERROR_BRIDGE_LENGTH;
    }
    
    public static String Move_Restrict(){
        return ERROR_MESSAGE + ERROR_MOVE;
    }    

    public static String Replay_Restrict(){
        return ERROR_MESSAGE + ERROR_RETRY;
    }
}
