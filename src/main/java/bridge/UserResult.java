package bridge;

import org.mockito.internal.matchers.Null;

public class UserResult {
    private String upperResult;
    private String lowerResult;

    public UserResult() {
        this.upperResult = null;
        this.lowerResult = null;
    }

    public void plusResult(String inputBridge, boolean isRightBridge) {
        plusBar();
        if (inputBridge.equals("U")) {
            selectUpperResult(inputBridge, isRightBridge);
            unselectLowerResult();
        }
        if (inputBridge.equals("D")) {
            selectLowerResult(inputBridge, isRightBridge);
            unselectUpperResult();
        }
    }

    public void selectUpperResult(String inputBridge, boolean isRightBridge) {
        if (inputBridge.equals("U")) {
            if(isRightBridge) {
                upperResult = upperResult + "O ";
            }
            if(!isRightBridge) {
                upperResult = upperResult + "X ";
            }
        }
    }

    public void unselectUpperResult() {
        upperResult = upperResult + "  ";
    }

    public void selectLowerResult(String inputBridge, boolean isRightBridge) {
        if (inputBridge.equals("D")) {
            if(isRightBridge) {
                lowerResult = lowerResult + "O ";
            }
            if(!isRightBridge) {
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
