package bridge;

public enum ErrorMessage {
    INVALID_RANGE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    INVALID_MOVING("[ERROR] 이동한 칸은 U 또는 D 여야 합니다."),
    INVALID_RETRY("[ERROR] 재시도는 R, 종료는 Q 여야 합니다");

    private final String desc;
    ErrorMessage( String desc){
        this.desc = desc;
    }

    public void getDesc(){
        System.out.println(desc);
    }
}
