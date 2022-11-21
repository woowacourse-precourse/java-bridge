package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge = new Bridge();
    private final Player player = new Player();
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(int index) {
        BridgeResult bridgeResult = new BridgeResult(bridge.getBridgeNumber(index).numberTypeCheck(index));
        PlayerResult playerResult = new PlayerResult(player.commandTypeCheck(index));
        if (bridgeResult.equals(playerResult)==true){

        }

    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }
    public int makeBridge(){
        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge.inputBridgeSize(size);
        bridge.inputBridgeNumber(bridgeMaker.makeBridge(size));
        return size;
    }
    public void setPlayer(){
        player.getInputMoving();
    }
}
