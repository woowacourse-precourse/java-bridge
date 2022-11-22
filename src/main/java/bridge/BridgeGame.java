package bridge;

import java.util.List;

public class BridgeGame {

    List<String> bridge;
    Boolean isCorrect;
    Integer bridgeIndex = 0;
    Integer tryNumber = 1;
    Boolean isSuccess = false;

    public BridgeGame(List<String> bridge) {
        bridge.add(" ");
        this.bridge = bridge;
    }

    private boolean isCorrect(String moving) {
        return moving.equals(bridge.get(bridgeIndex));
    }

    private boolean canMove() {
        return (bridgeIndex < bridge.size() - 2);
    }

    public void move(String moving) {
        if (!isCorrect(moving)) {
            System.out.println("can move and is not correct");
            isCorrect = false;
            bridgeIndex++;
            return;
        }
        if (canMove() && isCorrect(moving)) {
            System.out.println("can move and is correct");
            isCorrect = true;
            bridgeIndex++;
            return;
        }
        if (!canMove() && isCorrect(moving)) {
            System.out.println("cannot move and correct -> you success");
            isSuccess = true;
            bridgeIndex++;
        }
    }

    public void retry() {
        bridgeIndex--;
        isCorrect = true;
        tryNumber++;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }

    public int getBridgeIndex(){
        return bridgeIndex;
    }

    public String getBridgePosition() {
        return bridge.get(bridgeIndex - 1);
    }

    public int getTryNumber() {
        return tryNumber;
    }
}
