package bridge.view.enums;

public enum ExceptionString {
    NOT_NUMBER("[ERROR] 숫자가 아닙니다."),
    MIN_OR_MAX("[ERROR] 3이상 20이하의 숫자를 입력해야 함니다."),
    NOT_Q_R("[ERROR] Q 혹은 R을 선택해야 합니다."),
    NOT_U_D("[ERROR] U 혹은 D을 선택해야 합니다."),
    NOTNULL("[ERROR] 값을 넣어주어야 합니다.");

    private String print;

    ExceptionString(String print) {
        this.print = print;
    }

    public String getPrint() {
        return print;
    }
}
