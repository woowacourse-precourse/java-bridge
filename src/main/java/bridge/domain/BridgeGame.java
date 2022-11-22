package bridge.domain;

import bridge.view.InputView;

import static bridge.utils.Constants.*;
import static java.lang.System.exit;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    Player player;
    Bridge bridge;
    int bridgeSize;
    int blockNumber;

    public BridgeGame(Player player, Bridge bridge, int bridgeSize){
        this.player = player;
        this.bridge = bridge;
        this.bridgeSize = bridgeSize;
        blockNumber = 0;
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String playerMove) {
        player.MoveTo(playerMove);
        if(!player.isSuccess(bridge, blockNumber))
            return false;

        blockNumber++;
        if(bridgeSize == blockNumber) {
            success();
        }
        return true;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player.tryAgain();
        blockNumber = 0;
    }

    public void success(){
        System.out.println("성공");
    }
}
