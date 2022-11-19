package bridge.view.utils;

public class CustomStringBuilderForBridge {
    private StringBuilder upperBridge;
    private StringBuilder lowerBridge;

    public CustomStringBuilderForBridge() {
        upperBridge = new StringBuilder();
        lowerBridge = new StringBuilder();
    }

    public void addStartBracket() {
        upperBridge.append("[");
        lowerBridge.append("[");
    }

    public void addEndBracket() {
        upperBridge.append("]");
        lowerBridge.append("]");
    }

    public void addStick() {
        upperBridge.append("|");
        lowerBridge.append("|");
    }

    public void addO(String UorD) {
        if (UorD.equals("U")) {
            upperBridge.append(" O ");
            lowerBridge.append("   ");
        } else if (UorD.equals("D")) {
            upperBridge.append("   ");
            lowerBridge.append(" O ");
        }
    }

    public void addX(String UorD) {
        if (UorD.equals("U")) {
            upperBridge.append(" X ");
            lowerBridge.append("   ");
        } else if (UorD.equals("D")) {
            upperBridge.append("   ");
            lowerBridge.append(" X ");
        }
    }

    public StringBuilder getUpperBridge() {
        return upperBridge;
    }

    public StringBuilder getLowerBridge() {
        return lowerBridge;
    }
}
