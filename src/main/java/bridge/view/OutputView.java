package bridge.view;

import bridge.domain.BridgeMap;
import bridge.domain.BridgeMapMaker;
import bridge.domain.MovingStatus;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    private static final String FINAL_RESULT = "최종 게임 결과";
    private static final String GAME_SUCCESS_OR_NOT = "게임 성공 여부: ";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String TOTAL_RETRY_COUNT = "총 시도한 횟수: ";

    public static void printStartGameMessage() {
        System.out.println(START_GAME);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(final List<String> movingStatus) {
        System.out.println(printUpSideBridgeMap(movingStatus));
        System.out.println(printDownSideBridgeMap(movingStatus));
        System.out.print(System.lineSeparator());
    }

    private static BridgeMap printUpSideBridgeMap(final List<String> movingStatus) {
        BridgeMapMaker bridgeMapMaker = new BridgeMapMaker();
        return bridgeMapMaker
                .makeBridgeMap(movingStatus, MovingStatus.UP.getMovingKey());
    }

    private static BridgeMap printDownSideBridgeMap(final List<String> movingStatus) {
        BridgeMapMaker bridgeMapMaker = new BridgeMapMaker();
        return bridgeMapMaker
                .makeBridgeMap(movingStatus, MovingStatus.DOWN.getMovingKey());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(final List<String> movingStatus) {
        System.out.println(FINAL_RESULT);
        printMap(movingStatus);
    }

    public static void printGameSuccessOrNot(boolean isFail) {
        System.out.print(GAME_SUCCESS_OR_NOT);
        if (isFail) {
            System.out.println(FAIL);
        }
        if (!isFail) {
            System.out.println(SUCCESS);
        }
    }

    public static void printTotalRetryCount(int retryCount) {
        System.out.println(TOTAL_RETRY_COUNT + retryCount);
    }
}
