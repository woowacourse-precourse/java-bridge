package bridge;

import org.mockito.internal.matchers.Null;

public class UserResult {
    String upperResult = null;
    String lowerResult = null;


    public void plusUpperResult(String inputBridge, boolean rightBridge) {
        if (inputBridge.equals("U")) {
            if(rightBridge) {
                upperResult = upperResult + 'O' + ' ';
            }
            if(!rightBridge) {
                upperResult = upperResult + 'X' + ' ';
            }
        }
    }

    public void plusLowerResult(String inputBridge, boolean rightBridge) {
        if (inputBridge.equals("D")) {
            if(rightBridge) {
                lowerResult = lowerResult + 'O' + ' ';
            }
            if(!rightBridge) {
                lowerResult = lowerResult + 'X' + ' ';
            }
        }
    }

    public String getFinalUpperResult() {
        return "[ " + upperResult + "]";
    }

    public String getFinalLowerResult() {
        return "[ " + lowerResult + "]";
    }
}
