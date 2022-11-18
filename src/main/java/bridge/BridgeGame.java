package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final String CORRECT = "O";
    private final String WRONG = "X";
    private final String NOTHING = " ";
    private final List<List<String>> bridgePattern = new ArrayList<>();
    private final List<String> correctBridge;

    public BridgeGame(List<String> correctBridge) {
        this.correctBridge = correctBridge;
        for (int i = 0; i < 2; i++)
            this.bridgePattern.add(new ArrayList<>());
    }

    public void retry() {
    }

    private int toMovingNumber(String moving) {
        if (moving.equals("D"))
            return 0;
        return 1;
    }
}
