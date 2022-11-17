package bridge.validation.enums;

public enum RegEx {
    NUMBER_REG_EX("^[0-9]*$"),
    BRIDGE_SIZE_REG_EX("^[3-9]{1}$|^1{1}[0-9]{1}$|^20$");

    private final String regEx;

    RegEx(String regEx) {
        this.regEx = regEx;
    }

    public String getRegEx() {
        return regEx;
    }
}