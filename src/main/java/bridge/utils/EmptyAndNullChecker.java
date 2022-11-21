package bridge.utils;

public class EmptyAndNullChecker {
    public static void check(String input){
        try {
            if (input.isBlank()){
                throw new IllegalArgumentException("[ERROR]");
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }
}
