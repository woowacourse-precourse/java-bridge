package bridge;

import java.util.Arrays;

public enum Retry {
    R,
    Q;


    public static boolean checkRetry(String str){
        return str.equals(Retry.R.name());
    }
    public static boolean validRetry(String str){
        return Arrays.stream(Retry.values()).filter(c -> c.name().equals(str)).findAny().orElse(null) != null ? true : false;
    }
}