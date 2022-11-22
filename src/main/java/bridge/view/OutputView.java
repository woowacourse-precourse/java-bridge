package bridge.view;

import bridge.domain.BridgeGameStatus;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GREETING_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_RESULT_MESSAGE = "게임 성공 여부: ";
    private static final String TRY_COUNT_RESULT_MESSAGE = "총 시도한 횟수: ";
    private static final String SUCCESS_MESSAGE = "성공";
    private static final String FAIL_MESSAGE = "실패";

    public void printGreeting() {
        System.out.println(GREETING_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGameStatus bridgeGameStatus) {
        System.out.println(bridgeGameStatus.getUpBridgeString());
        System.out.println(bridgeGameStatus.getDownBridgeString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGameStatus bridgeGameStatus, int tryCount) {
        System.out.println(RESULT_MESSAGE);
        printMap(bridgeGameStatus);
        System.out.println(SUCCESS_RESULT_MESSAGE + getSuccessMessage(bridgeGameStatus));
        System.out.println(TRY_COUNT_RESULT_MESSAGE + tryCount);
    }
    
    private String getSuccessMessage(BridgeGameStatus bridgeGameStatus) {
        if (BridgeGameStatus.isArrived(bridgeGameStatus)) {
            return SUCCESS_MESSAGE;
        }
        
        return FAIL_MESSAGE;
    }
}
