package bridge.domain;

public enum GameCommandType {
    RETRY("R"),
    QUIT("Q");

    public final String code;

    GameCommandType(String code) {
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }
}
