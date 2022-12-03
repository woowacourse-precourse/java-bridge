package bridge;

public class CheckError {
    public void checkBridgeSize(int size){
        if(size < 3 || size >20) throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    public void checkChoice(String input_str){
        if(input_str.equals("U")) return;
        if(input_str.equals("D")) return;
        throw new IllegalArgumentException("[ERROR] U 또는 D만 입력해 주세요.");
    }

    public void checkRetry(String input_str){
        if(input_str.equals("R")) return;
        if(input_str.equals("Q")) return;
        throw new IllegalArgumentException("[ERROR] R 또는 Q만 입력해 주세요.");
    }
}
