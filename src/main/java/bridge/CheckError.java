package bridge;

public class CheckError {
    public void checkBridgeSize(int size){
        if(size < 3 || size >20) throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}
