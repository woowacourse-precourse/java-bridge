package bridge;

import java.util.Arrays;

public enum Retry {
    R,
    Q;

    public static boolean validRetry(String str){
        return Arrays.stream(Step.values()).filter(c -> c.name().equals(str)).count() > 0 ? true : false;
    }
}