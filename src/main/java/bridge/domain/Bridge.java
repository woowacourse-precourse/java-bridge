package bridge.domain;

import java.util.List;

public class Bridge {

    private final List<String> answerSheet;

    public Bridge(List<String> answerSheet) {
        this.answerSheet = answerSheet;
    }

    public int getBridgeSize() {
        return this.answerSheet.size();
    }

    public String getElementByIndex(int index) {
        return this.answerSheet.get(index);
    }
}
