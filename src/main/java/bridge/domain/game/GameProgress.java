package bridge.domain.game;

import bridge.domain.bridge.Move;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static bridge.support.MapConst.BLANK;
import static bridge.support.MapConst.BRIDGE_UNIT_DELIMITER;
import static bridge.support.MapConst.MAP_FORMAT;
import static bridge.support.MapConst.SYMBOL_FAIL;
import static bridge.support.MapConst.SYMBOL_FORMAT;
import static bridge.support.MapConst.SYMBOL_SUCCESS;

public class GameProgress {

    private final List<Progress> gameProgress;

    public GameProgress() {
        this.gameProgress = new ArrayList<>();
    }

    public boolean isLastMoveSuccess() {
        return gameProgress.get(gameProgress.size() - 1).isSuccess();
    }
    
    public void add(String moving, boolean success) {
        gameProgress.add(new Progress(Move.from(moving), success));
    }

    public int size() {
        return gameProgress.size();
    }

    public void clear() {
        gameProgress.clear();
    }

    public String getMap() {
        String upSide = getSideResultOf(Move.UP);
        String downSide = getSideResultOf(Move.DOWN);
        return String.format(MAP_FORMAT, upSide, downSide);
    }

    private String getSideResultOf(Move move) {
        List<String> results = gameProgress.stream()
                .map(progress -> getResult(progress, move))
                .collect(Collectors.toList());
        return String.join(BRIDGE_UNIT_DELIMITER, results);
    }

    private String getResult(Progress progress, Move move) {
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
    
    static class Progress {
        private final Move move;
        private final boolean success;
        
        public Progress(Move move, boolean success) {
            this.move = move;
            this.success = success;
        }
        
        public Move getMove() {
            return move;
        }
    
        public boolean isSuccess() {
            return success;
        }
    }
}
