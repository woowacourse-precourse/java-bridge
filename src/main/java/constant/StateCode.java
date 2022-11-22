package constant;

public enum StateCode {

    UP_CORRECT("UU", 1),
    UP_WRONG("UD", 2),
    DOWN_WRONG("DU", 3),
    DOWN_CORRECT("DD", 4);

    private final String state;
    private final int code;

    StateCode(String state, int code) {
        this.state = state;
        this.code = code;
    }

    public String getState() {
        return state;
    }

    public int getCode() {
        return code;
    }
}
