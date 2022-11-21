package bridge.domain.constants;

public enum ErrorMessage {
    ERROR_HEAD("[ERROR]");


    private String message;
    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
