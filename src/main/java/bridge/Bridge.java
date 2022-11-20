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

    public String toString() {
        StringBuilder up = new StringBuilder("[");
        StringBuilder down = new StringBuilder("[");
        appendUpBridge(up);
        appendDownBridge(down);

        up.append("]");
        down.append("]");

        return up.append("\n").append(down).toString();
    }

    private void appendUpBridge(StringBuilder up) {
        for (int i = 0 ; i < currentPosition ; i++) {
            up.append(getUpBridge(i));

            if (i + 1 < currentPosition) {
                up.append("|");
            }
        }
    }

    private void appendDownBridge(StringBuilder down) {
        for (int i = 0 ; i < currentPosition ; i++) {
            down.append(getDownBridge(i));
            if (i + 1 < currentPosition) {
                down.append("|");
            }
        }
    }

    private String getUpBridge(int position) {
        StringBuilder up = new StringBuilder();

        if (bridge.get(position).equals("U")) {
            up.append(" O ");
            return up.toString();
        }

        up.append("   ");
        return up.toString();
    }

    private String getDownBridge(int position) {
        StringBuilder down = new StringBuilder();

        if (bridge.get(position).equals("D")) {
            down.append(" O ");
            return down.toString();
        }

        down.append("   ");
        return down.toString();
    }
}
