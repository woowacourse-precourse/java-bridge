package bridge.utils;

import bridge.command.Move;
import bridge.domain.BridgeService;
import bridge.gamebridge.BridgeContainer;
import bridge.result.Result;
import java.util.ArrayList;
import java.util.List;

public class MoveTestUtils {
    private static final int LAST_ONE = 1;
    private static final int CURRENT_INDEX = 0;

    public static List<Move> convertStringListToMoveList(List<String> inputMoves) {
        List<Move> moves = new ArrayList<>();
        for (String inputMove : inputMoves) {
            moves.add(new Move(inputMove));
        }
        return moves;
    }

    public static Result insertMovesInService(List<String> inputMoves, BridgeService bridgeService) {
        List<Move> moves = convertStringListToMoveList(inputMoves);

        while (moves.size() != LAST_ONE) {
            bridgeService.insertMove(moves.remove(CURRENT_INDEX));
        }
        return bridgeService.insertMove(moves.remove(CURRENT_INDEX));
    }

    public static Result insertMovesInContainer(List<String> inputMoves, BridgeContainer bridgeContainer) {
        List<Move> moves = convertStringListToMoveList(inputMoves);
        while (moves.size() != LAST_ONE) {
            bridgeContainer.insertMove(moves.remove(CURRENT_INDEX));
        }
        return bridgeContainer.insertMove(moves.remove(CURRENT_INDEX));
    }
}
