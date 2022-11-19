package bridge.domain;

public class BridgeMonitor {
    private StringBuilder upperLine;
    private StringBuilder lowerLine;
    private static final String START_BRACKET = "[";
    private static final String SPACE = "   ";
    private static final String CORRECT_MOVING = " O ";
    private static final String WRONG_MOVING = " X ";
    private static final String BETWEEN_LINE = "|";
    private static final String END_BRACKET = "]";

    public BridgeMonitor() {
        this.upperLine = new StringBuilder(START_BRACKET);
        this.lowerLine = new StringBuilder(START_BRACKET);
    }
}
