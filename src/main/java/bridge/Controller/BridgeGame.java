package bridge.Controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Entity.BridgeMaker;
import bridge.Entity.BridgeSize;
import bridge.Entity.RandomBridge;
import bridge.Service.GenerateBridgeSize;
import bridge.View.InputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    public void start() {
        GenerateBridgeSize generateBridgeSize = new GenerateBridgeSize();
        int size = generateBridgeSize.getBridgeSize();


    }

    public void cycle(int size) {
        for (int i=0;i<size;i++) {

        }
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
