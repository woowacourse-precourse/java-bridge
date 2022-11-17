package bridge;

public class Constant {
    public static String Start_Game = "다리 건너기 게임을 시작합니다.";
    public static String Select_Location = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static String Select_Retry = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    public static String Error_Message = "[ERROR] ";
    public static String Err_Bridge_Length = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static String Err_Move = "이동 관련 입력은 U와 D만 사용 가능합니다.";
    public static String Err_Retry = "게임 종료 및 재시작 관련 입력은 R와 Q만 사용 가능합니다.";
    
    public static String Game_Start(){
        return Start_Game;
    }

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
