package bridge.service;

import bridge.model.entity.Bridge;
import bridge.model.entity.BridgeMap;
import bridge.model.entity.Player;
import bridge.util.BridgeMaker;
import bridge.view.InputView;
import bridge.view.InputView.*;

import static bridge.view.InputView.readBridgeSize;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
// 서비스 단계에서는 Input값과 model값만을 이용해서 구현한다.
public class BridgeGame {

    private Player player;
    private BridgeMap bridgeMap;
    private Bridge bridge;

    /*
    *
     */


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * User에게 입력을 받아서 U D 확인해야 한다.
     *
     */
    public void creatMap() {
        this.bridge = new Bridge(InputView.readBridgeSize());
    }

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
