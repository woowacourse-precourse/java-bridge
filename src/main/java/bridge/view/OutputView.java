package bridge.view;

import bridge.domain.BridgeResult;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String END_MESSAGE = "최종 게임 결과";
    private static final String FAIL_MESSAGE = "게임 성공 여부: 실퍠";
    private static final String SUCCESS_MESSAGE = "게임 성공 여부: 성공";

    private static final String COUNT_MESSAGE = "총 시도한 횟수:";

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> playerBridge, List<String> answerBridge) {
        BridgeResult bridgeResult = new BridgeResult(answerBridge);
        System.out.println(bridgeResult.matchBridge(playerBridge));
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String bridgeResult, int count) {
        System.out.println(END_MESSAGE);
        System.out.println(bridgeResult);
        printSuccessFail(bridgeResult);
        System.out.println(COUNT_MESSAGE + count);
    }

    private static void printSuccessFail(String bridgeResult) {
        if (isSuccess(bridgeResult)) {
            System.out.println(SUCCESS_MESSAGE);
            return;
        }
        System.out.println(FAIL_MESSAGE);
    }

    private static boolean isSuccess(String bridgeResult) {
        if (bridgeResult.contains("X")) {
            return false;
        }
        return true;
    }

    public static void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
