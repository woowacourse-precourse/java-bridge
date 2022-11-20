package bridge.Model;

public class BridgeSize {
    private final static int MIN_SIZE = 3;
    private final static int MAX_SIZE = 20;

    private int size;

    public BridgeSize(int size){
        validData(size);
        this.size = size;
    }

    private void validData(int data) throws IllegalArgumentException{
        if(MIN_SIZE >= 3 && MAX_SIZE <= 20){
            return;
        }
        throw new IllegalArgumentException("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}
