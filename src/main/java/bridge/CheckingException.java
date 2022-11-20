package bridge;

public class CheckingException {
    public void isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 올바른 숫자 입력값이 아닙니다.");
        }
    }

    public void isInputUorD(String moveSpaceAnswer) {
        if (!moveSpaceAnswer.equals("U") && !moveSpaceAnswer.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 올바른 위 아래 칸 입력 값이 아닙니다.");
        }
    }
}
