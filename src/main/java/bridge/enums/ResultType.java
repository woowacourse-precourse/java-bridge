package bridge.enums;

public enum ResultType {
    NOT_SELECT(" "),
    WRONG("X"),
    CORRECT("O");

    private String representation;

    ResultType(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }
}