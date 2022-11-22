package bridge.view;

import bridge.domain.BridgeGame;
import bridge.type.BridgeType;
import bridge.type.ResultType;
import bridge.domain.MoveLog;
import bridge.util.Message;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String BRIDGE_INIT = "[ ";
    private final String BRIDGE_FIN = " ]";
    private final String BRIDGE_BLOCK = " | ";
    private final String SUCCESS_RESULT = "게임 성공 여부: ";
    private final String TRIAL_COUNT = "총 시도한 횟수: ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(MoveLog moveLog) {
        System.out.println(BRIDGE_INIT + String.format("%s",
                String.join(BRIDGE_BLOCK, moveLog.getBridgeMoveLog().get(BridgeType.UP))) + BRIDGE_FIN);
        System.out.println(BRIDGE_INIT + String.format("%s",
                String.join(BRIDGE_BLOCK, moveLog.getBridgeMoveLog().get(BridgeType.DOWN))) + BRIDGE_FIN);
        enterLine();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, ResultType resultType) {
        printMessage(Message.FINAL_RESULT);
        printMap(bridgeGame.getMoveLog());
        System.out.println(SUCCESS_RESULT + resultType.getState());
        System.out.println(TRIAL_COUNT + bridgeGame.getTrial());
    }

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public void enterLine() {
        System.out.println();
    }

    public void printError(IllegalArgumentException error) {
        System.out.println(error.getMessage());
    }

}
