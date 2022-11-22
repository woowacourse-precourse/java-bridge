package bridge;

import java.util.List;

public class Bridge {

    private final List<String> bridgeAnswer;

    public Bridge(List<String> bridgeAnswer) {
        this.bridgeAnswer = bridgeAnswer;
    }

    public boolean checkAnswer(String movement, int movementCount) {
        return this.bridgeAnswer.get(movementCount).equals(movement);
    }

    public int getBridgeSize() {
        return this.bridgeAnswer.size();
    }
}
