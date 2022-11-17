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

    public void errorInputReadMoving(String inputUpDown) {
        if (!inputUpDown.equals("U") && !inputUpDown.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U나 D 중 한 글자여야 합니다.");
        }
    }

    public void errorInputRetry(String inputRetry) {
        if (!inputRetry.equals("R") && !inputRetry.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 재시작, 종료는 R이나 Q 중 한 글자여야 합니다.");
        }
    }

    public void errorInputCount(String inputCharacter) {
        if (inputCharacter.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 입력할 글자 수는 1개여야 합니다.");
        }
    }
}
