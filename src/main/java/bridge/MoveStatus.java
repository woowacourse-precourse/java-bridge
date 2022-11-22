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

    private List<List<String>> makeStatusMap(List<String> moveUpper, List<String> moveDowner) {
        if(moveMap.isEmpty()){
            moveMap.add(moveUpper);
            moveMap.add(moveDowner);
            return moveMap;
        }
        moveMap.set(0,moveUpper);
        moveMap.set(1,moveDowner);
        return moveMap;
    }


}
