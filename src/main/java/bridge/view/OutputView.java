package bridge.view;

import bridge.dto.GameResult;
import bridge.dto.MoveResult;

public class OutputView {

    private static final String GAME_SUCCESS = "성공";
    private static final String GAME_FAIL = "실패";

    private final MapGenerator mapGenerator = new MapGenerator();

    public void printMap(MoveResult moveResult) {
        mapGenerator.addCurrentRoundMap(moveResult);
        printJoiningMap();
    }

    private void printJoiningMap() {
        System.out.printf("[ %s ]\n", mapGenerator.getUpperMap());
        System.out.printf("[ %s ]\n", mapGenerator.getLowerMap());
    }

    public void clearMap() {
        mapGenerator.clear();
    }

    public void printResult(GameResult gameResult) {
        System.out.println("최종 게임 결과");
        printJoiningMap();
        System.out.printf("게임 성공 여부: %s\n", getGameClearResultMessage(gameResult));
        System.out.printf("총 시도한 횟수: %s\n", gameResult.getTryCount());
    }

    private String getGameClearResultMessage(GameResult gameResult) {
        if (gameResult.isGameClear()) {
            return GAME_SUCCESS;
        }
        return GAME_FAIL;
    }
}
