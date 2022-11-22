package bridge;

import java.util.regex.Pattern;

public class Exception {
    public void checkAlphabet(String moving) throws IllegalArgumentException {
        if (!Pattern.matches("^[A-Z]*$", moving)) {
            throw new IllegalArgumentException("알파벳 대문자로 입력하세요");
        }
    }

    public void checkRetryInput(String moving) throws IllegalArgumentException {
        if (!moving.equals("R") && !moving.equals("Q")) {
            throw new IllegalArgumentException(" R또는 Q로만 입력하세요.");
        }
    }

}
