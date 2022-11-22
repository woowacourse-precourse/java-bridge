package bridge;

import org.mockito.internal.matchers.Null;

public class UserResult {
    private String upperResult;
    private String lowerResult;

    public UserResult() {
        this.upperResult = null;
        this.lowerResult = null;
    }

    public void plusResult(String inputBridge, boolean rightBridge) {
        plusBar();
        if (inputBridge.equals("U")) {
            selectUpperResult(inputBridge, rightBridge);
            unselectLowerResult();
        }
        if (inputBridge.equals("D")) {
            selectLowerResult(inputBridge, rightBridge);
            unselectUpperResult();
        }
    }

    public void selectUpperResult(String inputBridge, boolean rightBridge) {
        if (inputBridge.equals("U")) {
            if(rightBridge) {
                upperResult = upperResult + "O ";
            }
            if(!rightBridge) {
                upperResult = upperResult + "X ";
            }
        }
    }

    public void unselectUpperResult() {
        upperResult = upperResult + "  ";
    }

    public void selectLowerResult(String inputBridge, boolean rightBridge) {
        if (inputBridge.equals("D")) {
            if(rightBridge) {
                lowerResult = lowerResult + "O ";
            }
            if(!rightBridge) {
                lowerResult = lowerResult + "X ";
            }
        }
    }

    public void unselectLowerResult() {
        lowerResult = lowerResult + "  ";
    }

    public void plusBar(){
        if (upperResult.length() != 0){
            upperResult = upperResult + "| ";
        }
        if (lowerResult.length() != 0){
            lowerResult = lowerResult + "| ";
        }
    }

    public String getFinalUpperResult() {
        return "[ " + upperResult + "]";
    }

    public String getFinalLowerResult() {
        return "[ " + lowerResult + "]";
    }
}
