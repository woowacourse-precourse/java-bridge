package bridge.Model;

public class ErrorUtil {
    public void errorBridgeSizeNotNumber(String inputSize) {
        for (int i=0;i<inputSize.length();i++) {
            if (inputSize.charAt(i) < '0' || inputSize.charAt(i) > '9')
                throw new IllegalArgumentException("[Error] 다리 길이는 숫자여야 합니다.");
        }
    }

    public void errorBridgeSize(int size) {
        if (size < 3 || size > 20)
            throw new IllegalArgumentException("[Error] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}
