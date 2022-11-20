package bridge;

import java.util.List;

public class Bridge {

    private final List<String> bridgeAnswer;

    public Bridge(List<String> bridgeAnswer) {
        this.bridgeAnswer = bridgeAnswer;
    }

    public int getBridgeSize() {
        return this.bridgeAnswer.size();
    }

    public String getAnswerByCount(int movementCount) {
        return this.bridgeAnswer.get(movementCount);
    }
}
