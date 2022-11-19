package view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
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

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> moveBridgeResult) {
        int upBridge = moveBridgeResult.size() - 2;
        int downBridge = moveBridgeResult.size() - 1;
        System.out.println(moveBridgeResult.get(upBridge));
        System.out.println(moveBridgeResult.get(downBridge));
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> moveBridgeResult, int tryCount) {
        System.out.println(FINAL_GAME_RESULT);
        int upBridge = moveBridgeResult.size() - 2;
        int downBridge = moveBridgeResult.size() - 1;
        System.out.println(moveBridgeResult.get(upBridge));
        System.out.println(moveBridgeResult.get(downBridge));
        System.out.println();
    }

    public void printFailedResult(int tryCount) {
        System.out.println(PRINT_GAME_FAILED);
        System.out.println(TOTAL_TRY_COUNT + tryCount);
    }

    public void printSuccessResult(int tryCount) {
        System.out.println(PRINT_GAME_SUCCESS);
        System.out.println(TOTAL_TRY_COUNT + tryCount);
    }
}