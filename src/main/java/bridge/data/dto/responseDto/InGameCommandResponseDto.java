package bridge.data.dto.responseDto;

import static bridge.type.ErrorMessageDevType.BAD_MID_RESULT_MESSAGE;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class InGameCommandResponseDto {

    private final List<String> bridgeMap;
    private final List<String> moves;

    public InGameCommandResponseDto(List<String> bridgeMap, List<String> moves) {
        validateMoves(bridgeMap, moves);
        this.bridgeMap = Collections.unmodifiableList(bridgeMap);
        this.moves = Collections.unmodifiableList(moves);
    }

    private static void validateMoves(List<String> bridgeMap, List<String> moves) {
        if (hasDifferentElementInFront(bridgeMap, moves)) {
            throw new IllegalStateException(BAD_MID_RESULT_MESSAGE.toString());
        }
    }

    private static boolean hasDifferentElementInFront(List<String> bridgeMap, List<String> moves) {
        return !IntStream.range(0, moves.size() - 1)
                .allMatch(index -> moves.get(index).equals(bridgeMap.get(index)));
    }

    public List<String> getMoves() {
        return moves;
    }

    public String getLastMove() {
        return moves.get(moves.size() - 1);
    }

    public boolean isPlayerDead() {
        return !isLastElementSame();
    }

    public boolean isGameCleared() {
        return haveEqualSizes() && isLastElementSame();
    }

    private boolean isLastElementSame() {
        int lastIndex = moves.size() - 1;
        return moves.get(lastIndex).equals(bridgeMap.get(lastIndex));
    }

    private boolean haveEqualSizes() {
        return moves.size() == bridgeMap.size();
    }
}
