package bridge.view;

import static bridge.domain.command.MoveCommand.MOVE_TO_LOWER_BLOCK;
import static bridge.domain.command.MoveCommand.MOVE_TO_UPPER_BLOCK;

import bridge.domain.Bridge;
import bridge.dto.GameResult;
import bridge.dto.MoveResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String ANSWER_IS_RIGHT = "O";
    private static final String ANSWER_IS_WRONG = "X";
    private static final String BLANK = " ";

    private static final String UPPER_BLOCKS_KEY = "upper";
    private static final String LOWER_BLOCKS_KEY = "lower";

    private static final String GAME_CLEAR_SUCCESS = "성공";
    private static final String GAME_CLEAR_FAIL = "실패";

    public void printMap(Bridge bridge,
                         MoveResult moveResult) {
        Map<String, String> recentValue = getRecentValueResult(moveResult);
        Map<String, List<String>> otherValues = getOtherValues(bridge, moveResult.getRound());
        printJoiningMessage(recentValue, otherValues);
    }

    public void printResult(Bridge bridge,
                            GameResult gameResult) {
        System.out.println("최종 게임 결과");
        printMap(bridge, gameResult.getMoveResult());
        System.out.printf("게임 성공 여부: %s\n", getSuccessMessage(gameResult));
        System.out.printf("총 시도한 횟수: %s\n", gameResult.getTryCount());
    }

    private Map<String, String> getRecentValueResult(MoveResult moveResult) {
        String message = moveResult.getMessage();
        String resultMark = getResultMark(moveResult.isSuccess());

        if (message.equals(MOVE_TO_UPPER_BLOCK)) {
            return Map.of(UPPER_BLOCKS_KEY, resultMark, LOWER_BLOCKS_KEY, BLANK);
        }

        return Map.of(UPPER_BLOCKS_KEY, BLANK, LOWER_BLOCKS_KEY, resultMark);
    }

    private String getResultMark(boolean isSuccess) {
        if (isSuccess) {
            return ANSWER_IS_RIGHT;
        }
        return ANSWER_IS_WRONG;
    }

    private Map<String, List<String>> getOtherValues(Bridge bridge, int round) {
        List<String> upperBlocks = new ArrayList<>();
        List<String> lowerBlocks = new ArrayList<>();

        //TODO -1 상수 네이밍 떠올리자
        bridge.getBlocks()
                .stream()
                .limit(round -1)
                .forEach(block -> setOtherValues(upperBlocks, lowerBlocks, block));

        return Map.of(UPPER_BLOCKS_KEY, upperBlocks, LOWER_BLOCKS_KEY, lowerBlocks);
    }

    private void setOtherValues(List<String> up, List<String> down, String block) {
        if (block.equals(MOVE_TO_UPPER_BLOCK)) {
            up.add(ANSWER_IS_RIGHT);
            down.add(BLANK);
        }

        if (block.equals(MOVE_TO_LOWER_BLOCK)) {
            up.add(BLANK);
            down.add(ANSWER_IS_RIGHT);
        }
    }

    private void printJoiningMessage(Map<String, String> recentValue,
                                     Map<String, List<String>> otherValues) {
        List<String> upperBlocks = otherValues.get(UPPER_BLOCKS_KEY);
        upperBlocks.add(recentValue.get(UPPER_BLOCKS_KEY));

        List<String> lowerBlocks = otherValues.get(LOWER_BLOCKS_KEY);
        lowerBlocks.add(recentValue.get(LOWER_BLOCKS_KEY));

        System.out.printf("[ %s ]\n", String.join(" | ", upperBlocks));
        System.out.printf("[ %s ]\n", String.join(" | ", lowerBlocks));
    }

    private String getSuccessMessage(GameResult gameResultTest) {
        if (gameResultTest.isGameClear()) {
            return GAME_CLEAR_SUCCESS;
        }
        return GAME_CLEAR_FAIL;
    }
}
