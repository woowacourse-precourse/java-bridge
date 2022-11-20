package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeOfUser {

    private List<String> upSide;
    private List<String> downSide;

    public BridgeOfUser() {
        upSide = new ArrayList<>();
        downSide = new ArrayList<>();
    }

    public void restoreByRigth(String moveSide) {
        if (moveSide.equals(Side.UP.ofString())) {
            upSide.add(" O ");
            downSide.add("   ");
        }
        if (moveSide.equals(Side.DOWN.ofString())) {
            upSide.add("   ");
            downSide.add(" O ");
        }
    }

    public void restoreByWrong(String moveSide) {
        if (moveSide.equals(Side.UP.ofString())) {
            upSide.add(" X ");
            downSide.add("   ");
        }
        if (moveSide.equals(Side.DOWN.ofString())) {
            upSide.add("   ");
            downSide.add(" X ");
        }
    }

    @Override
    public String toString() {
        String upSideString = "[" + String.join("|", upSide) + "]";
        String downSideString = "[" + String.join("|", downSide) + "]";
        return upSideString + "\n" + downSideString;
    }

    public boolean equalsWithComputerMapLength(int length) {
        return upSide.size() == length;
    }
}
