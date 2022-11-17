package bridge.Model;

public class ErrorUtil {
    public void errorBridgeSize(String inputSize) {
        for (int i=0;i<inputSize.length();i++) {
            if (inputSize.charAt(i) < '0' || inputSize.charAt(i) > '9')
                throw new  IllegalArgumentException("[Error] 다리길이는 숫자여야 합니다.");
        }
    }
}
