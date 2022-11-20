package bridge;

import java.util.List;

public class Bridge {

    private final List<String> bridge;

    private int currentPosition;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.currentPosition = 0;
    }

    public boolean move(String movingPlace) {
        if (isPossibleToMove(movingPlace)) {
            currentPosition++;
            return true;
        }

        return false;
    }

    private boolean isPossibleToMove(String movingPlace) {
        return bridge.get(currentPosition).equals(movingPlace);
    }

    public void print() {
        for (String one : bridge) {
            System.out.print(one + " ");
        }
        System.out.println();
    }
}
