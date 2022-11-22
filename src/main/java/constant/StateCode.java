package constant;

public enum StateCode {

    U_TRUE("UU", 1),
    U_FALSE("UD", 2),
    D_FALSE("DU", 3),
    D_TRUE("DD", 4);

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
