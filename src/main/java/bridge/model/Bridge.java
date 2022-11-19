package bridge.model;

import bridge.validator.BridgeValidator;

import java.util.List;

public class Bridge {

    private final List<String> answerSheet;

    public Bridge(List<String> answerSheet) {
        this.answerSheet = answerSheet;
    }

    public int getBridgeSize() {
        return this.answerSheet.size();
    }

    public boolean getResult(String answer, int index) {
        BridgeValidator.checkBridgeIndexValid(this.answerSheet.size(), index);
        if (this.answerSheet.get(index).equals(answer)) {
            return true;
        }
        return false;
    }
}
