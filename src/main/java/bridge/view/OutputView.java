package bridge.view;

import static bridge.domain.vo.MoveCommand.MOVE_TO_LOWER_BLOCK;
import static bridge.domain.vo.MoveCommand.MOVE_TO_UPPER_BLOCK;

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

    private static final String GAME_SUCCESS = "성공";
    private static final String GAME_FAIL = "실패";

    private static final String ROUND_SEPARATE_MARK = " | ";

    private static final int FOR_GET_ONLY_OTHER_ROUND_RESULT = 1;

    /**
     * 성공 & 실패 여부가 불확실한 현재 라운드 결과(getCurrentRoundResult)와
     * 성공일 수 밖에 없는 이전 라운드를 별개의 로직으로(getOtherRoundResult) 구하여 지도를 출력
     */
    public void printMap(Bridge bridge,
                         MoveResult moveResult) {
        Map<String, String> currentRoundResult = getCurrentRoundResult(moveResult);
        Map<String, List<String>> otherRoundResult = getOtherRoundResult(bridge, moveResult.getRound());

        printEachJoiningBlocks(currentRoundResult, otherRoundResult, UPPER_BLOCKS_KEY);
        printEachJoiningBlocks(currentRoundResult, otherRoundResult, LOWER_BLOCKS_KEY);
    }

    public void printResult(Bridge bridge,
                            GameResult gameResult) {
        System.out.println("최종 게임 결과");
        printMap(bridge, gameResult.getMoveResult());
        System.out.printf("게임 성공 여부: %s\n", getGameClearResultMessage(gameResult));
        System.out.printf("총 시도한 횟수: %s\n", gameResult.getTryCount());
    }

    private Map<String, String> getCurrentRoundResult(MoveResult moveResult) {
        String resultMark = getResultMark(moveResult.isSuccess());

        if (moveResult.getMessage().equals(MOVE_TO_UPPER_BLOCK)) {
            return Map.of(UPPER_BLOCKS_KEY, resultMark, LOWER_BLOCKS_KEY, BLANK);
        }

        return Map.of(UPPER_BLOCKS_KEY, BLANK, LOWER_BLOCKS_KEY, resultMark);
    }

    private String getResultMark(boolean success) {
        if (success) {
            return ANSWER_IS_RIGHT;
        }
        return ANSWER_IS_WRONG;
    }

    private Map<String, List<String>> getOtherRoundResult(Bridge bridge, int round) {
        List<String> upperBlocks = new ArrayList<>();
        List<String> lowerBlocks = new ArrayList<>();

        bridge.getBlocks()
                .stream()
                .limit(round - FOR_GET_ONLY_OTHER_ROUND_RESULT)
                .forEach(block -> setOtherValues(upperBlocks, lowerBlocks, block));

        return Map.of(UPPER_BLOCKS_KEY, upperBlocks, LOWER_BLOCKS_KEY, lowerBlocks);
    }

    private void setOtherValues(List<String> upperBlocks, List<String> lowerBlocks, String block) {
        if (block.equals(MOVE_TO_UPPER_BLOCK)) {
            upperBlocks.add(ANSWER_IS_RIGHT);
            lowerBlocks.add(BLANK);
        }

        if (block.equals(MOVE_TO_LOWER_BLOCK)) {
            upperBlocks.add(BLANK);
            lowerBlocks.add(ANSWER_IS_RIGHT);
        }
    }

    private void printEachJoiningBlocks(Map<String, String> recentValue,
                                        Map<String, List<String>> otherValues,
                                        String key) {
        List<String> blocks = otherValues.get(key);
        blocks.add(recentValue.get(key));
        System.out.printf("[ %s ]\n", String.join(ROUND_SEPARATE_MARK, blocks));
    }

    private String getGameClearResultMessage(GameResult gameResult) {
        if (gameResult.isGameClear()) {
            return GAME_SUCCESS;
        }
        return GAME_FAIL;
    }
}
