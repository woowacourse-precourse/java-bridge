package bridge.domain.exception;

import bridge.domain.resources.UpOrDown;

public class UDIllegalArgumentException extends IllegalArgumentException{

    private static final String ONLY_U_OR_D = String.format("[ERROR] %s과 %s만 입력이 가능합니다.", UpOrDown.UP, UpOrDown.DOWN);

    public UDIllegalArgumentException() {
        super(ONLY_U_OR_D);
    }
}
