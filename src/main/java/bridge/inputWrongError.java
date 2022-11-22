package bridge;

public class inputWrongError {
    public void bridgeSizeError(int size){
        if(size < 3 || size >20) throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
    public void moveError(String inputString)
    {
        if(inputString.equals("U")) return;
        if(inputString.equals("D")) return;
        throw new IllegalArgumentException("[ERROR] U 또는 D만 입력이 가능합니다.");
    }
    public void retryError(String inputString)
    {
        if(inputString.equals("R")) return;
        if(inputString.equals("Q")) return;
        throw new IllegalArgumentException("[ERROR] R 또는 Q만 입력이 가능합니다.");
    }
}
