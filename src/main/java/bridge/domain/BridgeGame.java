package bridge.domain;

import bridge.BridgeKey;
import bridge.CrossResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final Bridge bridge;
    private final MoveResults moveResults = new MoveResults();

    private final List<CrossResult> upMapParameter = new ArrayList<>();
    private final List<CrossResult> downMapParaMeter = new ArrayList<>();

    public BridgeGame(BridgeMaker bridgeMaker, int size) {
        this.bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    public void move(String controlKey) {
        moveResults.addResult(bridge.moveResult(moveResults().size(), controlKey));
        addMapParameter();
    }


    public void retry() {
        moveResults.addTryNum();
        removeMapLast();
        moveResults.removeFailure();
    }

    public List<String> upMap() {
        return upMapParameter.stream().map(CrossResult::getSuccessFailureLetter).collect(Collectors.toList());
    }

    public void addMapParameter() {
        addUpMap();
        addDownMap();
    }

    private void addUpMap() {
        MoveResult moveResult = moveResults.getMoveResults().get(moveResults.size() - 1);

        BridgeKey bridgeKey = BridgeKey.upBridgeKey(moveResult.getControlKey());
        upMapParameter.add(CrossResult.findCrossResult(bridgeKey.getBridgeKey(), moveResult.isMatchResult()));
    }

    private void removeMapLast() {
        if (moveResults.getMoveResults().isEmpty()) {
            upMapParameter.remove(0);
            downMapParaMeter.remove(0);
            return;
        }
        int lastValue = moveResults.size() - 1;
        upMapParameter.remove(lastValue);
        downMapParaMeter.remove(lastValue);
    }

    public List<String> downMap() {
        return downMapParaMeter.stream().map(CrossResult::getSuccessFailureLetter).collect(Collectors.toList());
    }

    private void addDownMap() {
        MoveResult moveResult = moveResults.getMoveResults().get(moveResults.size() - 1);
        BridgeKey bridgeKey = BridgeKey.downBridgeKey(moveResult.getControlKey());
        downMapParaMeter.add(CrossResult.findCrossResult(bridgeKey.getBridgeKey(), moveResult.isMatchResult()));
    }

    public boolean isSuccess() {
        return moveResults.success();
    }

    public int bridgeSize() {
        return bridge.size();
    }

    public MoveResults moveResults() {
        return moveResults;
    }

}
