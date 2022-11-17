package bridge;

public class Exception {

    public static void lengthrangeException(int input) {
        if (input > 20 || input < 3) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
