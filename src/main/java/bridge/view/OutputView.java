package bridge.view;

import bridge.domain.BridgeGame;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    static final String LEFT_SQUARE = "[ ";
    static final String RIGHT_SQUARE = " ]";
    static final String VERTICAL_BAR = " | ";
    static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    static final String GAME_CLEAR_MESSAGE = "게임 성공 여부: 성공";
    static final String GAME_FAIL_MESSAGE = "게임 성공 여부: 실패";
    static final String TOTAL_TRY_MESSAGE = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upBridge, List<String> downBridge) {
        System.out.println(LEFT_SQUARE + String.join(VERTICAL_BAR, upBridge) + RIGHT_SQUARE);
        System.out.println(LEFT_SQUARE + String.join(VERTICAL_BAR, downBridge) + RIGHT_SQUARE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> upBridge, List<String> downBridge, BridgeGame bridgeGame) {
        System.out.println(FINAL_RESULT_MESSAGE);
        printMap(upBridge, downBridge);
        if(bridgeGame.isClear()) {
            System.out.println(GAME_CLEAR_MESSAGE);
            System.out.println(TOTAL_TRY_MESSAGE + bridgeGame.getTotalGamePlay());
            return;
        }
        System.out.println(GAME_FAIL_MESSAGE);
        System.out.println(TOTAL_TRY_MESSAGE + bridgeGame.getTotalGamePlay());
    }
}
