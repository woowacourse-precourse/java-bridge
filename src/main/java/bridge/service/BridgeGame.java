package bridge.service;

import bridge.domain.BridgeMaker;
import bridge.domain.Player;
import bridge.dto.CurrentPositionDto;
import bridge.dto.ResultDto;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final BridgeMaker bridgeMaker;
    private final Player player;
    public BridgeGame(BridgeMaker bridgeMaker, Player player) {
        this.bridgeMaker = bridgeMaker;
        this.player = player;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        player.move(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        player.increaseTryCount();
        player.initMoveHistory();
    }

    public void makeBridge(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        player.addBridge(bridge);
    }

    public CurrentPositionDto getCurrentPosition() {
        List<String> bridge = player.getBridge();
        List<String> moveHistory = player.getMoveHistory();
        CurrentPositionDto currentPositionDto = new CurrentPositionDto(bridge, moveHistory);
        return currentPositionDto;
    }

    public boolean isPlayerFailToMove() {
        return player.isFailToMove();
    }

    public boolean isPlayerCompleteToMove() {
        return player.isCompleteToMove();
    }

    public ResultDto getResultDto() {
        int tryCount = player.getTryCount();
        boolean isComplete = player.isCompleteToMove();
        CurrentPositionDto currentPosition = getCurrentPosition();
        return new ResultDto(tryCount, isComplete, currentPosition);
    }
}
