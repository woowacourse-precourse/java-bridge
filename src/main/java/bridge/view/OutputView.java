package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> upBridge, List<String> downBridge) {
        String upBridgeMap = String.join(ViewMessage.WALL_PRINT.getMessage(), upBridge);
        String downBridgeMap = String.join(ViewMessage.WALL_PRINT.getMessage(), downBridge);

        System.out.println(ViewMessage.HEAD_PRINT.getMessage() + upBridgeMap + ViewMessage.TAIL_PRINT.getMessage());
        System.out.println(ViewMessage.HEAD_PRINT.getMessage() + downBridgeMap + ViewMessage.TAIL_PRINT.getMessage());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String successOrFail, String tryNumber) {
        System.out.println(ViewMessage.RESULT_GAME_SUCCESS_STATUS_MESSAGE.getMessage() + successOrFail);
        System.out.println(ViewMessage.RESULT_GAME_TRY_NUMBER_MESSAGE.getMessage() + tryNumber);
    }

    public void printGameStart() {
        System.out.println(ViewMessage.START_GAME_MESSAGE.getMessage());
    }
}
