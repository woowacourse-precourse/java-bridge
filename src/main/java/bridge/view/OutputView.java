package bridge.view;

import bridge.domain.BridgeStatus;
import bridge.domain.PlayerStatus;

import static bridge.utils.constant.OutputMessage.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeStatus bridgeStatus) {
        System.out.println(bridgeStatus);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(PlayerStatus status, BridgeStatus bridgeStatus) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(bridgeStatus);
        String successOrNot = status.getName();
        int tryCount = status.getTryCount();
        System.out.println(SUCCESS_OR_NOT_MESSAGE + successOrNot);
        System.out.println(TRY_COUNT_MESSAGE + tryCount);
    }

    public void printGameStart() {
        System.out.println(START_GAME_MESSAGE);
    }
}
