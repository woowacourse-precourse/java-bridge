package bridge;

public class Validator {
    public static void isNumber(String number){
        if (!number.matches("[0-9]+")){
            throw new IllegalArgumentException("[ERROR] 입력이 숫자가 아닙니다.");
        }
    }
}
