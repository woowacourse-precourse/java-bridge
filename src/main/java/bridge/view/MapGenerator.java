package bridge.view;

import static bridge.domain.vo.MoveCommand.MOVE_TO_LOWER_BLOCK;
import static bridge.domain.vo.MoveCommand.MOVE_TO_UPPER_BLOCK;

import bridge.dto.MoveResult;
import java.util.ArrayList;
import java.util.List;

public class MapGenerator {

    private static final String ANSWER_IS_RIGHT = "O";
    private static final String ANSWER_IS_WRONG = "X";
    private static final String BLANK = " ";
    private static final String ROUND_SEPARATE_MARK = " | ";

    private final List<String> upperBlocks = new ArrayList<>();
    private final List<String> lowerBlocks = new ArrayList<>();

    public void addCurrentRoundMap(MoveResult moveResult) {
        String resultMark = getResultMark(moveResult.isSuccess());
        if (moveResult.getMessage().equals(MOVE_TO_UPPER_BLOCK)) {
            upperBlocks.add(resultMark);
            lowerBlocks.add(BLANK);
        }
        if (moveResult.getMessage().equals(MOVE_TO_LOWER_BLOCK)) {
            upperBlocks.add(BLANK);
            lowerBlocks.add(resultMark);
        }
    }

    public String getUpperMap() {
        return String.join(ROUND_SEPARATE_MARK, upperBlocks);
    }

    public String getLowerMap() {
        return String.join(ROUND_SEPARATE_MARK, lowerBlocks);
    }

    private String getResultMark(boolean success) {
        if (success) {
            return ANSWER_IS_RIGHT;
        }
        return ANSWER_IS_WRONG;
    }

    public void clear() {
        upperBlocks.clear();
        lowerBlocks.clear();
    }
}
