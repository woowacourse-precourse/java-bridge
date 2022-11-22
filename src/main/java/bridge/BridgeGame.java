package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */

//인스턴스 변수 추가 가능
//패키지 변경 가능
//메서드 이름 변경 불가, 인자와 반환타입은 변경 가능
//게임 진행을 위해 필요한 메서드 추가, 변경 가능
// InputView, OutputView 사용 불가
public class BridgeGame {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public Bridge make(int bridgeSize) {
        return new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Bridge bridge, String inputMove) {
        bridge.compareWithBridge(inputMove);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Bridge bridge) {
            bridge.restartBridge();
            bridge.plusTryCount();
    }
}
