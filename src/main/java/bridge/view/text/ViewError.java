package bridge.view.text;

import bridge.domain.constants.Command;
import bridge.domain.constants.Constant;

public enum ViewError {
    ERROR_HEAD("[ERROR]"),
    IS_NOT_INTEGER("다리의 길이는 정수여야 합니다."),
    COMMAND_LENGTH_OUT_OF_RANGE("커맨드는 하나의 대문자 알파벳으로 주어져야 합니다.");

    private String message;
    ViewError(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
