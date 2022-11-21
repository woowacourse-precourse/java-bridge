package bridge.exception;

public class CheckUpDownException extends IllegalArgumentException {
    public static final String ENTER_U_OR_D = "[ERROR] U or D 를 입력해주세요";
    public CheckUpDownException() {
        super(ENTER_U_OR_D);
    }
}
