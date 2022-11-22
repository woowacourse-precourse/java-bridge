package bridge;

import bridge.Bridge;

import static bridge.GameController.GAME_COUNT;


public class OutputView {
    private static final String FINAL_GAME_RESULT = "최종 게임 결과";
    private static final String GAME_SUCCESS = "게임 성공 여부: %s\n";
    private static final String GAME_TOTAL_COUNT = "총 시도한 횟수: %d";

    public void printMap(Bridge bridge) {
        System.out.println("[ " + String.join(" | ", bridge.resultUpBridge) + " ]");
        System.out.println("[ " + String.join(" | ", bridge.resultDownBridge) + " ]");
    }


    public void printResult(String successFail, Bridge bridge) {
        System.out.println(FINAL_GAME_RESULT);
        System.out.println("[ " + String.join(" | ", bridge.resultUpBridge) + " ]");
        System.out.println("[ " + String.join(" | ", bridge.resultDownBridge) + " ]");
        System.out.printf(GAME_SUCCESS, successFail);
        System.out.printf(GAME_TOTAL_COUNT, GAME_COUNT);
    }
}
