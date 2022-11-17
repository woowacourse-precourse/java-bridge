package bridge.utils;

public class Validator {
    public void checkSizeInRange(int size) {
        if (3 > size || size > 20) {
            throw new IllegalArgumentException("3 이상 20 이하의 숫자만 입력가능합니다");
        }
    }
}
