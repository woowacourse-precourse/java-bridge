package bridge.view;

import static bridge.domain.vo.MoveCommand.MOVE_TO_LOWER_BLOCK;
import static bridge.domain.vo.MoveCommand.MOVE_TO_UPPER_BLOCK;

import bridge.dto.GameResult;
import bridge.dto.MoveResult;
import java.util.ArrayList;
import java.util.List;

public class OutputView {

    private static final String GAME_SUCCESS = "성공";
    private static final String GAME_FAIL = "실패";
    private static final String ANSWER_IS_RIGHT = "O";
    private static final String ANSWER_IS_WRONG = "X";
    private static final String BLANK = " ";
    private static final String ROUND_SEPARATE_MARK = " | ";

    private final List<String> upperBlocks = new ArrayList<>();
    private final List<String> lowerBlocks = new ArrayList<>();

    public void printMap(MoveResult moveResult) {
        String resultMark = getResultMark(moveResult.isSuccess());
        addCurrentRoundMap(moveResult.getMessage(), resultMark);
        printJoiningMap();
    }

    public void clearMap() {
        upperBlocks.clear();
        lowerBlocks.clear();
    }

    public void printResult(GameResult gameResult) {
        System.out.println("최종 게임 결과");
        printJoiningMap();
        System.out.printf("게임 성공 여부: %s\n", getGameClearResultMessage(gameResult));
        System.out.printf("총 시도한 횟수: %s\n", gameResult.getTryCount());
    }

    private void addCurrentRoundMap(String message, String resultMark) {
        if (message.equals(MOVE_TO_UPPER_BLOCK)) {
            upperBlocks.add(resultMark);
            lowerBlocks.add(BLANK);
        }
        if (message.equals(MOVE_TO_LOWER_BLOCK)) {
            upperBlocks.add(BLANK);
            lowerBlocks.add(resultMark);
        }
    }

    private String getResultMark(boolean success) {
        if (success) {
            return ANSWER_IS_RIGHT;
        }
        return ANSWER_IS_WRONG;
    }

    private void printJoiningMap() {
        System.out.printf("[ %s ]\n", String.join(ROUND_SEPARATE_MARK, upperBlocks));
        System.out.printf("[ %s ]\n", String.join(ROUND_SEPARATE_MARK, lowerBlocks));
    }

    private String getGameClearResultMessage(GameResult gameResult) {
        if (gameResult.isGameClear()) {
            return GAME_SUCCESS;
        }
        return GAME_FAIL;
    }
}
