package bridge;

/**
 * 입력값이 맞는지 확인해주는 클래스
 */
public class InputException {
    public int checkLengthBridge(String size) {
        int resultSize = isNumberic(size);
        isCorrectRangeException(resultSize);
        return resultSize;
    }

    public int isNumberic(String size) {
        try {
            int resultSize = Integer.parseInt(size);
            return resultSize;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void isCorrectRangeException(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("[ERROR]3부터 20 사이의 숫자를 입력하세요");
        }
    }
}
