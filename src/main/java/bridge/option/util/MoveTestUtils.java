package bridge.option.util;

import bridge.option.Move;
import java.util.ArrayList;
import java.util.List;

public class MoveTestUtils {

    public static List<Move> convertStringListToMoveList(List<String> inputMoves) {
        List<Move> moves = new ArrayList<>();
        for (String inputMove : inputMoves) {
            moves.add(new Move(inputMove));
        }
        return moves;
    }
}
