package bridge.view;

public enum Map {
    START("[ "),
    END(" ]"),
    JOIN(" | "),
    MOVE_SUCCESS("O"),
    MOVE_FAIL("X"),
    MOVE_EMPTY(" "),;

    private final String code;

    Map(String code){
        this.code = code;
    }

    public String code(){
        return code;
    }
}
