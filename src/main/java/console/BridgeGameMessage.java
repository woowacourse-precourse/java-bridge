package console;

public enum BridgeGameMessage {
    REDO("R"),
    QUIT("Q");

    private final String message;

    BridgeGameMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
