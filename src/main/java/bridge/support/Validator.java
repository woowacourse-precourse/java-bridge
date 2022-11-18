package bridge.support;

public class Validator {
    private static final int START_RANGE=3;
    private static final int END_RANGE=20;
    private static final int SIZE=1;
    private static final String COMMON_ERROR_MESSAGE="[ERROR] ";
    public static void checkInteger(String target){
        if(target.matches("[0-9]+")){
            throw new IllegalArgumentException(COMMON_ERROR_MESSAGE+"숫자를 입력해야 합니다.");
        }
    }
    public static void checkSize(String target){
        if(target.length()!=SIZE){
            throw new IllegalArgumentException(COMMON_ERROR_MESSAGE+"한자리 숫자여야 합니다.");
        }
    }
}
