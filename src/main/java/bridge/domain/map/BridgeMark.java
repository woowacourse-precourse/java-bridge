package bridge.domain.map;

public enum BridgeMark {

    START("["),
    END("]"),
    WRONG(" X "),
    CORRECT(" O "),
    BLANK("   "),
    DELIMITER("|");

    private final String mark;

    BridgeMark(String mark) {
        this.mark = mark;
    }

    public String getMark(){
        return mark;
    }
}
