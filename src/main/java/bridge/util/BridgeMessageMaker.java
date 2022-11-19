package bridge.util;

public class BridgeMessageMaker {

    private final String PARTITION = " | ";

    private StringBuilder upperLine = new StringBuilder();
    private StringBuilder lowerLine = new StringBuilder();

    public void upLineMessageMaker(String moveResult, boolean b) {
        upperLine.append(moveResult);
        if (b) {
            upperLine.append(PARTITION);
        }
    }

    public void downLineMessageMaker(String moveResult, boolean b) {
        lowerLine.append(moveResult);
        if (b) {
            lowerLine.append(PARTITION);
        }
    }

    public StringBuilder getUpperLine() {
        return upperLine;
    }

    public StringBuilder getLowerLine() {
        return lowerLine;
    }
}
