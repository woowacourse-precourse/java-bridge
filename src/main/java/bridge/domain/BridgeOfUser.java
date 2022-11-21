package bridge.domain;

import bridge.domain.common.Side;
import bridge.utils.Validator;
import java.util.ArrayList;
import java.util.List;

public class BridgeOfUser {

    private final List<String> upSide;
    private final List<String> downSide;

    public BridgeOfUser() {
        upSide = new ArrayList<>();
        downSide = new ArrayList<>();
    }

    public void restoreByRigth(String moveSide) {
        Validator.checkIsSide(moveSide);
        if (moveSide.equals(Side.UP.ofString())) {
            addToUpSide("O");
        }
        if (moveSide.equals(Side.DOWN.ofString())) {
            addToDownSide("O");
        }
    }

    public void restoreByWrong(String moveSide) {
        Validator.checkIsSide(moveSide);
        if (moveSide.equals(Side.UP.ofString())) {
           addToUpSide("X");
        }
        if (moveSide.equals(Side.DOWN.ofString())) {
            addToDownSide("X");
        }
    }

    private void addToDownSide(String result) {
        upSide.add("   ");
        downSide.add(" " + result + " ");
    }

    private void addToUpSide(String result) {
        upSide.add(" " + result + " ");
        downSide.add("   ");
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
