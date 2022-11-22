package bridge.view;

import static bridge.view.Message.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(String bridgeMap) {
        System.out.println(bridgeMap);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(String bridgeMap, String result, int tryCount) {
        System.out.println(FINAL_REPORT);
        System.out.println(bridgeMap);

        System.out.println();
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + tryCount);
    }

    public void printStartMessage() {
        System.out.println(START);
        System.out.println();
    }

    public void printInputBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printInputBridge() {
        System.out.println(INPUT_BRIDGE);
    }

    public void printRetryMessage() {System.out.println(RETRY);}
}
