package view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String START_GAME = "다리 건너기 게임을 시작합니다.";
    private final String FINAL_GAME_RESULT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
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
        int upBridge = moveBridgeResult.size() - 1;
        int downBridge = moveBridgeResult.size() - 2;
        System.out.println(moveBridgeResult.get(upBridge));
        System.out.println(moveBridgeResult.get(downBridge));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> moveBridgeResult) {
        System.out.println(FINAL_GAME_RESULT);
        System.out.println(moveBridgeResult);
    }
}
