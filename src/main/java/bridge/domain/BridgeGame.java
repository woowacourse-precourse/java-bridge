package bridge.domain;

import bridge.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeNumberGenerator bridgeNumberGenerator;
    private BridgeMaker bridgeMaker;
    private Bridge bridge;
    private Player player;
    private List<String> bridgeStatus;
    private int attempt;
    private boolean gameStatus;


    public BridgeGame(int bridgeSize) {
        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
        player = new Player();
        bridgeStatus = new ArrayList<>();
        attempt = 0;
        gameStatus = false;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String movingInput) {
        player.movePlayer(movingInput);
        List<String> playerMoving = player.getPlayerMoving();
        if (!bridge.isMove(playerMoving, playerMoving.size() - 1)) {
            bridgeStatus.add(Constant.IMPOSSIBLE.getConstant());
            return;
        }
        bridgeStatus.add(Constant.POSSIBLE.getConstant());
    }

    public List<String> getplayerMoving() {
        return player.getPlayerMoving();
    }

    public List<String> getBridgeStatus() {
        return bridgeStatus;
    }

    public boolean gameOver() {
        return gameStatus || bridgeStatus.size() == bridge.getBridgeSize();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
