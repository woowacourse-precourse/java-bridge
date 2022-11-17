package bridge.model;

public class Bridge {

    private static StringBuilder upperBridge = new StringBuilder();
    private static StringBuilder lowerBridge = new StringBuilder();

    public static StringBuilder getUpperBridge() {
        return upperBridge;
    }

    public static StringBuilder getLowerBridge() {
        return lowerBridge;
    }
}
