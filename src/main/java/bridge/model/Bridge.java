package bridge.model;

import bridge.validator.BridgeValidator;

import java.util.List;

public class Bridge {

    private final List<String> answerSheet;

    public Bridge(final List<String> answerSheet) {
        this.answerSheet = answerSheet;
    }

    public int getBridgeSize() {
        return this.answerSheet.size();
    }

    public boolean getResult(final String answer, final int index) {
        return this.answerSheet
                .get(BridgeValidator.checkBridgeIndexValid(this.answerSheet.size(), index))
                .equals(answer);
    }
}
