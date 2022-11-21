package bridge.ui;

import bridge.domain.BridgeGameHost;
import bridge.domain.GameProgress;

import static bridge.constant.Const.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printOpeningPhrase() {
        System.out.println(OPENING_PHRASE);
    }

    public void printRequestBridgeSize() {
        System.out.println(REQUEST_BRIDGE_SIZE);
    }

    public void printRequestMoving() {
        System.out.println(REQUEST_MOVING);
    }

    public void printRequestRestart() {
        System.out.println(REQUEST_RESTART);
    }

    public void printError(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() { // 여기서 player 위치는 index 로 따졌을 때 현재 위치인 것
        System.out.println(GameProgress.map());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGameHost bridgeGameHost) {
        System.out.println(GameProgress.result(bridgeGameHost));
    }
}
