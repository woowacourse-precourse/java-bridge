package bridge;

public enum ExceptionString {
    NOT_NUMBER("[ERROR] 숫자가 아닙니다."),
    MIN_OR_MAX("[ERROR] 3이상 20이하의 숫자를 입력해야 함니다.");

    private String print;

    ExceptionString(String print) {
        this.print = print;
    }

    public String getPrint() {
        return print;
    }
}
