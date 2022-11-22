package bridge.model;

public class Bridge {

    private final StringBuilder upperBridge;
    private final StringBuilder lowerBridge;

    public Bridge(StringBuilder upperBridge, StringBuilder lowerBridge) {
        this.upperBridge = upperBridge;
        this.lowerBridge = lowerBridge;
    }

    public StringBuilder getUpperBridge() {
        return upperBridge;
    }

    public StringBuilder getLowerBridge() {
        return lowerBridge;
    }
}
