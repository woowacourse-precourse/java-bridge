package bridge.console;

import bridge.console.utility.MapDrawer;
import bridge.data.FinalResult;
import bridge.data.MoveResult;

import java.util.List;

public class OutputView {
    private final static String FINAL_RESULT_HEADING = "최종 게임 결과";
    private final static String GAME_RESULT = "게임 성공 여부: ";
    private final static String NUMBER_OF_ATTEMPTS = "총 시도한 횟수: ";

    private static OutputView instance;

    private final MapDrawer mapDrawer;

    private OutputView() {
        this.mapDrawer = new MapDrawer();
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printMap(List<MoveResult> moveResults) {
        StringBuilder upperRow = new StringBuilder();
        StringBuilder lowerRow = new StringBuilder();
        this.mapDrawer.drawMap(moveResults, upperRow, lowerRow);

        System.out.println(upperRow + System.lineSeparator() + lowerRow + System.lineSeparator());
    }

    public void printResult(FinalResult finalResult) {
        System.out.println(FINAL_RESULT_HEADING);
        printMap(finalResult.getMoveResults());
        System.out.println(GAME_RESULT + finalResult.getGameResult().getValue());
        System.out.println(NUMBER_OF_ATTEMPTS + finalResult.getNumAttempts());
    }
}
