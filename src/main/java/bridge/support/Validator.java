package bridge.support;

public class Validator {
    public static void checkInteger(String target){
        if(target.matches("[0-9]+")){
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }
}
