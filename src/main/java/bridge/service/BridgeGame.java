package bridge.service;

import bridge.domain.BridgeJudge;
import bridge.domain.BridgeMaker;
import bridge.domain.Player;
import bridge.dto.CurrentPositionDto;
import bridge.dto.ResultDto;

import java.util.List;

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
        player.initForRetry();
    }

    public void makeBridge(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeJudge.addBridge(bridge);
    }

    public CurrentPositionDto getCurrentPosition() {
        List<String> bridge = bridgeJudge.getBridge();
        List<String> moveHistory = player.getMoveHistory();
        return new CurrentPositionDto(bridge, moveHistory);
    }

    public boolean isPlayerFailToMove() {
        List<String> moveHistory = player.getMoveHistory();
        return bridgeJudge.isFailToMove(moveHistory);
    }

    public boolean isPlayerCompleteToMove() {
        List<String> moveHistory = player.getMoveHistory();
        return bridgeJudge.isCompleteToMove(moveHistory);
    }

    public ResultDto getResultDto() {
        int tryCount = player.getTryCount();
        boolean isComplete = isPlayerCompleteToMove();
        CurrentPositionDto currentPosition = getCurrentPosition();
        return new ResultDto(tryCount, isComplete, currentPosition);
    }
}
