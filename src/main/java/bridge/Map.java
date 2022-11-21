package bridge;

import bridge.domain.BridgeDirection;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private static final String DIVIDING_LINE = "|";
    private static final String PASS = "O";
    private static final String NOT_PASS = "X";
    private static final String BLANK = " ";
    private final List<List<String>> map = new ArrayList<>();

    Map() {
        for (int LayerIndex = 0; LayerIndex < BridgeDirection.getBridgeDirectionSize(); LayerIndex++) {
            map.add(new ArrayList<>());
        }
    }


    public void drawMap(int numberOfMove, String moveDirection, boolean canMove) {
        checkCount(numberOfMove);
        for (int LayerIndex = 0; LayerIndex < BridgeDirection.getBridgeDirectionSize(); LayerIndex++) {
            map.get(LayerIndex).add(checkDirection(LayerIndex, moveDirection, canMove));
        }
    }

    private void checkCount(int numberOfMove) {
        if (numberOfMove != 0) {
            for (List<String> mapLayer : map) {
                mapLayer.add(DIVIDING_LINE);
            }
        }
    }

    private String checkDirection(int LayerIndex, String moveDirection, boolean canMove) {
        if (LayerIndex == BridgeDirection.getDirectionNumber(moveDirection))
            return checkOX(canMove);
        return BLANK;
    }

    private String checkOX(boolean canMove) {
        if (canMove) {
            return PASS;
        }
        return NOT_PASS;
    }

}
