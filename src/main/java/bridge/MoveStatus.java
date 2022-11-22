package bridge;

import java.util.ArrayList;
import java.util.List;

public class MoveStatus {
    List<String> moveUpper = new ArrayList<>();
    List<String> moveDowner = new ArrayList<>();
    List<List<String>> moveMap = new ArrayList<>();
    public List<List<String>> printMoves(String moves, boolean checkIfAvailableToMove) {
        if (moves.equals("U")) {
            addUpper(checkIfAvailableToMove);
        }
        if (moves.equals("D")) {
            addDowner(checkIfAvailableToMove);
        }
        return makeStatusMap(moveUpper, moveDowner);
    }


}
