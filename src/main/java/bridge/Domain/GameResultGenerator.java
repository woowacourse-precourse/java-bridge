package bridge.Domain;

import bridge.EnumCollections.BridgeResultType;

import java.util.ArrayList;
import java.util.List;

public class GameResultGenerator {
    private final List<String> upperBridge;
    private final List<String> lowerBridge;

    public GameResultGenerator() {
        this.upperBridge = new ArrayList<>();
        this.lowerBridge = new ArrayList<>();
    }

    public String getUpperBridgeResult(GameResult gameResult) {
        if (!gameResult.isPositionUpper()) {
            return BridgeResultType.NONE.getResult();
        }
        if (gameResult.isMoveSuccess()) {
            return BridgeResultType.POSSIBLE.getResult();
        }
        return BridgeResultType.IMPOSSIBLE.getResult();
    }

    public String getLowerBridgeResult(GameResult gameResult) {
        if (gameResult.isPositionUpper()) {
            return BridgeResultType.NONE.getResult();
        }
        if (gameResult.isMoveSuccess()) {
            return BridgeResultType.POSSIBLE.getResult();
        }
        return BridgeResultType.IMPOSSIBLE.getResult();
    }

    public void addBridgeStatus(String upperResult, String lowerResult) {
        upperBridge.add(upperResult);
        lowerBridge.add(lowerResult);
    }

    public String getGameResultOutput() {
        String upBridge = makeBridgeOutput(upperBridge);
        String lowBridge = makeBridgeOutput(lowerBridge);
        return upBridge + '\n' + lowBridge;
    }

    public String makeBridgeOutput(List<String> bridge) {
        return "[ " + String.join(" | ", bridge) + " ]";
    }

    public void initGameResult() {
        upperBridge.clear();
        lowerBridge.clear();
    }

    public String getBridgeStatus(GameResult gameResult) {
        String lowerResult = getLowerBridgeResult(gameResult);
        String upperResult = getUpperBridgeResult(gameResult);
        addBridgeStatus(upperResult, lowerResult);
        return getGameResultOutput();
    }
}
