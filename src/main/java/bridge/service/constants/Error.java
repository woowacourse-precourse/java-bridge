package bridge.service.constants;

public enum Error {
    ERROR("[ERROR] ");

    private final String error;

    Error(String error){
        this.error = error;
    }

    public String getError(){
        return error;
    }
}
