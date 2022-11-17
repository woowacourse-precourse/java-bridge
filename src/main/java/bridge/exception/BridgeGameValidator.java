package bridge.exception;

public class BridgeGameValidator {

    public static void isValidGameNumber(int number) {
        if (!(number >= 3 && number <= 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
