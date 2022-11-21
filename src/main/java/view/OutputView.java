package view;

import java.util.List;

public class OutputView {
    private final String START_GAME = "다리 건너기 게임을 시작합니다.";
    private final String FINAL_GAME_RESULT = "최종 게임 결과";
    private final String PRINT_GAME_FAILED = "게임 성공 여부: 실패";
    private final String PRINT_GAME_SUCCESS = "게임 성공 여부: 성공";
    private final String TOTAL_TRY_COUNT = "총 시도한 횟수: ";

    public void printStart() {
        System.out.println(START_GAME);
        System.out.println();
    }

    public void printMap(List<String> moveResult) {
        int upBridge = moveResult.size() - 2;
        int downBridge = moveResult.size() - 1;
        System.out.println(moveResult.get(upBridge));
        System.out.println(moveResult.get(downBridge));
        System.out.println();
    }

    public void printFailedResult(List<String> moveResult, int gameCount) {
        int lastSize = moveResult.size() - 1;
        System.out.println(FINAL_GAME_RESULT);
        System.out.println(moveResult.get(lastSize - 1));
        System.out.println(moveResult.get(lastSize));
        System.out.println();
        System.out.println(PRINT_GAME_FAILED);
        System.out.println(TOTAL_TRY_COUNT + gameCount);
    }

    public void printSuccessResult(List<String> moveResult, int gameCount) {
        int lastSize = moveResult.size() - 1;
        System.out.println(FINAL_GAME_RESULT);
        System.out.println(moveResult.get(lastSize - 1));
        System.out.println(moveResult.get(lastSize));
        System.out.println();
        System.out.println(PRINT_GAME_SUCCESS);
        System.out.println(TOTAL_TRY_COUNT + gameCount);
    }
}