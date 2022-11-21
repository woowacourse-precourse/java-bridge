package bridge;

import java.util.Arrays;

public enum Retry {
    R,
    Q;

    public static boolean checkRetry(String str){
        return str.equals(Retry.R.name());
    }

    public static boolean validRetry(String str){
        if(Arrays.stream(Retry.values()).filter(c -> c.name().equals(str)).findAny().orElse(null) == null)
            return false;

        return true;
    }
}