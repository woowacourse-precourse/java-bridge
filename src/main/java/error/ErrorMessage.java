package error;

public enum ErrorMessage {
    BRIDGE_LENGTH_ERROR("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    BRIDGE_LENGTH_INPUT_ERROR("[ERROR] 다리 길이는 숫자만 입력 가능합니다."),
    BRIDGE_SELECT_ERROR("[ERROR] U와 D중 하나만 입력 가능합니다."),
    RESTART_SELECT_ERROR("[ERROR] R과 Q중 하나만 입력 가능합니다.");

    private final String errormessage;

    ErrorMessage(String errormessage){
        this.errormessage = errormessage;
    }

    public String getErrormessage(){
        return errormessage;
    }
}
