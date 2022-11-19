package bridge.service;

import bridge.domain.BridgeJudge;
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
    private final BridgeJudge bridgeJudge;
    private final Player player;


    public BridgeGame(BridgeMaker bridgeMaker, BridgeJudge bridgeJudge, Player player) {
        this.bridgeMaker = bridgeMaker;
        this.bridgeJudge = bridgeJudge;
        this.player = player;
    }

    public void move(String direction) {
        player.move(direction);
    }

    public void retry() {
        player.increaseTryCount();
        player.initMoveHistory();
    }

    public void makeBridge(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeJudge.addBridge(bridge);
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
