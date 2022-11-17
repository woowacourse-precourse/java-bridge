package bridge.view;

import bridge.constant.BridgeGameInfo;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        System.out.println("현재 이동한 다리 상태 출력(미완성)");
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(BridgeGameInfo.RESULT);
    }

    // 게임시작 메세지 출력
    public static void printStart() {
        System.out.println(BridgeGameInfo.START.message);
    }

    // 시도 횟수 출력
    public void printTryNumber() {
        System.out.println(BridgeGameInfo.TOTAL_TRY.message);
    }

    // 성공 여부 출력
    public void printSuccessFailure() {
        System.out.println(BridgeGameInfo.SUCSSES_FAILURE);
    }
}
