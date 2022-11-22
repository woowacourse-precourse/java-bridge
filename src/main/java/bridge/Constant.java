package bridge;

public class Constant {
    public static final String Start_Game = "다리 건너기 게임을 시작합니다.";
    public static final String Select_Location = "\n이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String Select_Retry = "\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String Input_Length = "\n다리의 길이를 입력해주세요.";

    public static final String Error_Message = "[ERROR] ";
    public static final String Err_Bridge_Length = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static final String Err_Move = "이동 관련 입력은 U와 D만 사용 가능합니다.";
    public static final String Err_Retry = "게임 종료 및 재시작 관련 입력은 R와 Q만 사용 가능합니다.";
    
    public static final String Result_of_game = "\n최종 게임 결과";
    public static final String Total_Try = "총 시도한 횟수: ";
    public static final String Result_of_try = "\n게임 성공 여부: ";
    public static final String Num_Regex = "[1-9][0-9]*";
    public static final String Front = "[ ";
    public static final String Back = "]";
    public static final String Delimiter = "| ";

    public static final String Win = "성공";
    public static final String Lose = "실패";

    public static final String Down = "D";
    public static final String Up = "U";

    public static final String Restart = "R";
    public static final String Quit = "Q";

    public static final String Success = "O";
    public static final String Fail = "X";
    public static final String Space = " ";

    public static String Select_Move(){
        return Select_Location;
    }

    public static String Select_Replay(){
        return Select_Retry;
    }

    public static String Length_Restrict(){
        return Error_Message + Err_Bridge_Length;
    }
    
    public static String Move_Restrict(){
        return Error_Message + Err_Move;
    }
    

    public static String Replay_Restrict(){
        return Error_Message + Err_Retry;
    }

}
