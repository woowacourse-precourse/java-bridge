package bridge.domain;

public enum GameMessageStorage {
    UP("U"),
    DOWN("D");

    private final String message;

    GameMessageStorage(String message){
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }
}
