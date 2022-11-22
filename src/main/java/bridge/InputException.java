package bridge;

/**
 * 입력값이 맞는지 확인해주는 클래스
 */
public class InputException {
    public int checkLengthBridge(String size) {
        int resultSize = (int)isNumberic(size);
        isCorrectRangeException(resultSize);
        return resultSize;
    }

    public double isNumberic(String size) {
        try {
            double resultSize = Double.parseDouble(size);
            return resultSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요");
        }
    }

    public void isCorrectRangeException(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR]3부터 20 사이의 숫자를 입력하세요");
        }
    }


    public String checkUpDown(String upDown) {
        if (!upDown.equals("U") && !upDown.equals("D")) {
            throw new IllegalArgumentException("[ERROR]U,D만 입력 가능합니다");
        }
        return upDown;
    }

    public String checkRetry(String retry) {
        if (!retry.equals("R") && !retry.equals("Q")) {
            throw new IllegalArgumentException("[ERROR]R,Q만 입력 가능합니다");
        }
        return retry;
    }
}
