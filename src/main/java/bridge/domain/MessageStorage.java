package bridge.domain;

public enum MessageStorage {
    UP("U"),
    DOWN("D");

    private final String message;

    MessageStorage(String message){
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }
}
