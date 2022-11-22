package bridge.domain;

public class BridgeMonitor {
    private StringBuffer upperLine;
    private StringBuffer lowerLine;
    private static final String START_BRACKET = "[";
    private static final String END_BRACKET = "]";
    private static final String CORRECT_MOVING = " O ";
    private static final String WRONG_MOVING = " X ";
    private static final String SPACE = "   ";
    private static final String MID_LINE = "|";

    public BridgeMonitor(){
        this.upperLine = new StringBuffer(START_BRACKET);
        this.lowerLine = new StringBuffer(START_BRACKET);
    }



}
