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

    public void move(String moving, int bridgeNum) {
        int moveNum = toMovingNumber(moving);
        String answer = this.correctBridge.get(bridgeNum);
        this.bridgePattern.get(1 - moveNum).add(NOTHING);

        if (moving.equals(answer))
            this.bridgePattern.get(moveNum).add(CORRECT);
        if (!moving.equals(answer))
            this.bridgePattern.get(moveNum).add(WRONG);
    }

    public void retry() {
    }

    private int toMovingNumber(String moving) {
        if (moving.equals("D"))
            return 0;
        return 1;
    }
}
