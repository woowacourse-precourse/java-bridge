package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final String CORRECT = "O";
    private final String WRONG = "X";
    private final String NOTHING = " ";
    private final List<String> correctBridge;
    public final List<List<String>> bridgePattern = new ArrayList<>();

    public BridgeGame(List<String> correctBridge) {
        this.correctBridge = correctBridge;
        newBridgePattern();
    }

    public boolean move(String moving, int bridgeNum) {
        int moveNum = toMovingNumber(moving);
        String answer = this.correctBridge.get(bridgeNum);
        this.bridgePattern.get(1 - moveNum).add(NOTHING);

        if (moving.equals(answer)) {
            this.bridgePattern.get(moveNum).add(CORRECT);
            return true;
        }
        this.bridgePattern.get(moveNum).add(WRONG);
        return false;
    }

    public void retry() {
        newBridgePattern();
    }

    private void newBridgePattern() {
        this.bridgePattern.clear();
        for (int i = 0; i < 2; i++)
            this.bridgePattern.add(new ArrayList<>());
    }

    private int toMovingNumber(String moving) {
        if (moving.equals("D"))
            return 1;
        return 0;
    }
}
