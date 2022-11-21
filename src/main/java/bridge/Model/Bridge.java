package bridge.Model;

import java.util.List;

public class Bridge {

    private final List<String> bridgeAnswer;

    public Bridge(List<String> bridgeAnswer) {
        this.bridgeAnswer = bridgeAnswer;
    }

    public int getBridgeSize() {
        return this.bridgeAnswer.size();
    }

    public boolean checkAnswer(String movement, int movementCount) {
        return this.bridgeAnswer.get(movementCount).equals(movement);
    }
}
