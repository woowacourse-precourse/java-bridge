package bridge.view;

import bridge.domain.game.SuccessStep;
import bridge.message.Message;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */

public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printMap(String bridgeMap) {
        System.out.println(bridgeMap);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void printResult(String map, boolean success, int totalTrial) {
        System.out.println(Message.PRINT_RESULT.getMessage());
        printMap(map);
        System.out.println(Message.WHETHER_SUCCESS.getMessage()+SuccessStep.getResultbyStatus(success));
        System.out.println(Message.TOTAL_TRIAL.getMessage()+totalTrial);
    }

    public void askBridgeLen(){
        System.out.println(Message.START_GAME.getMessage());
        System.out.println(Message.ASK_LENGTH.getMessage());
    }

    public void askRestart(){
        System.out.println(Message.ASK_RESTART.getMessage());
    }

    public void askStep(){
        System.out.println(Message.ASK_STEP.getMessage());
    }

}
