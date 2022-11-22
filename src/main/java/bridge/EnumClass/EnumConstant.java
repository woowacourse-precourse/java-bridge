package bridge.EnumClass;

public enum EnumConstant {
    State_Retry("R Q"),
    State_Move("U D");

    private String state;

    EnumConstant(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
