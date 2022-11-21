package bridge;

public class InputValidate {
    private static final String UPPER_ROW="U";
    private static final String DOWN_ROW="D";
    private static final String QUIT="Q";
    private static final String RETRY="R";

    public int validateBridgeSize(int size){
        if(size<3||size>20){
            throw new IllegalArgumentException("다리 길이는 3~20사이의 수여야 합니다.");
        }
        return size;
    }

    public String validateMove(String move){
        if(UPPER_ROW.equals(move)||DOWN_ROW.equals(move)){
            return move;
        }
        throw new IllegalArgumentException("이동할 칸은 U/D 중 하나의 문자를 입력할 수 있습니다.");
    }

    public String validateRetry(String retry){
        if(QUIT.equals(retry)||RETRY.equals(retry)){
            return retry;
        }
        throw new IllegalArgumentException("재시작/종료 여부는 R/Q 중 하나의 문자를 입력할 수 있습니다.");
    }
}
