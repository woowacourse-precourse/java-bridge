package bridge.view.utils;

import static bridge.constant.Constants.*;

public class CustomStringBuilderForBridge {
    private StringBuilder upperBridge;
    private StringBuilder lowerBridge;

    public CustomStringBuilderForBridge() {
        upperBridge = new StringBuilder();
        lowerBridge = new StringBuilder();
    }

    public void addStartBracket() {
        upperBridge.append(START_BRACKET);
        lowerBridge.append(START_BRACKET);
    }

    public void addEndBracket() {
        upperBridge.append(END_BRACKET);
        lowerBridge.append(END_BRACKET);
    }

    public void addStick() {
        upperBridge.append(STICK);
        lowerBridge.append(STICK);
    }

    public void addO(String UorD) {
        if (UP_COMMAND.equals(UorD)) {
            upperBridge.append(O_SIGN);
            lowerBridge.append(THREE_SPACES);
        } else if (DOWN_COMMAND.equals(UorD)) {
            upperBridge.append(THREE_SPACES);
            lowerBridge.append(O_SIGN);
        }
    }

    public void addX(String UorD) {
        if (UP_COMMAND.equals(UorD)) {
            upperBridge.append(X_SIGN);
            lowerBridge.append(THREE_SPACES);
        } else if (DOWN_COMMAND.equals(UorD)) {
            upperBridge.append(THREE_SPACES);
            lowerBridge.append(X_SIGN);
        }
    }

    public StringBuilder getUpperBridge() {
        return upperBridge;
    }

    public StringBuilder getLowerBridge() {
        return lowerBridge;
    }
}
