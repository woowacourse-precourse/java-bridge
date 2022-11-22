package bridge;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.service.Map;
import bridge.service.Move;
import bridge.view.InputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> bridge;

    public void play(){
        set();
        move();
    }
    public void set(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
    }
    public void move() {
        Map map = new Map();
        Move move = new Move(bridge);
        while(move.isKeepGoing()){
            String moveDirection = InputView.readMoving();
            move.moveBridge(moveDirection);
            map.drawMap(moveDirection,move.getMoveResult());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
