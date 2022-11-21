package bridge.domain;

import bridge.domain.Move;
import bridge.domain.game.GameProgress;
import bridge.domain.game.MoveResult;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.support.MapConst.BLANK;
import static bridge.support.MapConst.BRIDGE_UNIT_DELIMITER;
import static bridge.support.MapConst.MAP_FORMAT;
import static bridge.support.MapConst.SYMBOL_FAIL;
import static bridge.support.MapConst.SYMBOL_FORMAT;
import static bridge.support.MapConst.SYMBOL_SUCCESS;

public class MapManager {

    public String getMap(GameProgress gameProgress) {
        String upSide = getSideResultOf(gameProgress, Move.UP);
        String downSide = getSideResultOf(gameProgress, Move.DOWN);
        return String.format(MAP_FORMAT, upSide, downSide);
    }

    private String getSideResultOf(GameProgress gameProgress, Move move) {
        List<String> results = gameProgress.stream()
                .map(progress -> getResult(progress, move))
                .collect(Collectors.toList());
        return String.join(BRIDGE_UNIT_DELIMITER, results);
    }

    private String getResult(MoveResult progress, Move move) {
        if (move.equals(progress.getMove())) {
            return String.format(SYMBOL_FORMAT, getSymbol(progress.isSuccess()));
        }
        return BLANK;
    }

    private String getSymbol(boolean success) {
        if (success) {
            return SYMBOL_SUCCESS;
        }
        return SYMBOL_FAIL;
    }
}
