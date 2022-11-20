package bridge;

public class CheckingException {
    public void isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자 입력값이 아닙니다.");
        }
    }
}
