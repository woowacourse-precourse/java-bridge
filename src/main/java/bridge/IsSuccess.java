package bridge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public enum IsSuccess {
    SUCCESS("true", "성공"),
    FAIL("false", "실패");

    private final String check;
    private final String word;

    IsSuccess(String check, String word) {
        this.check = check;
        this.word = word;
    }

    public static IsSuccess isSuccess(HashMap<String, List<String>> result) {
        String success = String.valueOf(!Arrays.toString(result.values().toArray()).contains("X"));
        return Arrays.stream(IsSuccess.values())
                .filter(isSuccess -> isSuccess.getCheck().equals(success))
                .findAny().orElse(FAIL);
    }

    public String getCheck() {
        return check;
    }

    public String getWord() {
        return word;
    }
}
