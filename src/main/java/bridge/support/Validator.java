package bridge.support;

public class Validator {
    private static final String COMMON_ERROR_MESSAGE="[ERROR] ";
    public static void checkInteger(String target){
        if(target.matches("[0-9]+")){
            throw new IllegalArgumentException(COMMON_ERROR_MESSAGE+"숫자를 입력해야 합니다.");
        }
    }
}
