package bridge.Model;

public class ErrorUtil {
    public void errorBridgeSizeNotNumber(String inputSize) {
        for (int i=0;i<inputSize.length();i++) {
            if (inputSize.charAt(i) < '0' || inputSize.charAt(i) > '9') {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자여야 합니다.");
            }
        }
    }

    public void errorBridgeSize(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public  void errorInputReadMoving(String inputUpDown) {
        if (!inputUpDown.equals("U") && !inputUpDown.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U나 D 중 한 글자여야 합니다.");
        }
    }
}
