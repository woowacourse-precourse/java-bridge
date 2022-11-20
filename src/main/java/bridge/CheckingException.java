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

    public void isInputRorQ(String retryAnswer) {
        if (!retryAnswer.equals("R") && !retryAnswer.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 올바른 재시도 종료 입력 값이 아닙니다.");
        }
    }
}
