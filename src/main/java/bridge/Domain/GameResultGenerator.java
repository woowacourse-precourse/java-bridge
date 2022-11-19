package bridge.Domain;

import bridge.EnumCollections.BridgeResultType;

import java.util.ArrayList;
import java.util.List;

public class GameResultGenerator {
    private List<String> upperBridge;
    private List<String> lowerBridge;

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
        this.upperBridge.add(upperResult);
        this.lowerBridge.add(lowerResult);
    }

    public String getGameResultOutput() {
        String upBridge = makeBridgeOutput(this.upperBridge);
        String lowBridge = makeBridgeOutput(this.lowerBridge);
        return upBridge + '\n' + lowBridge;
    }

    public String makeBridgeOutput(List<String> bridge) {
        return "[ " + String.join(" | ", bridge) + " ]";
    }

    public void initGameResult() {
        this.upperBridge = new ArrayList<>();
        this.lowerBridge = new ArrayList<>();
    }

    public String getBridgeStatus(GameResult gameResult) {
        String lowerResult = getLowerBridgeResult(gameResult);
        String upperResult = getUpperBridgeResult(gameResult);
        addBridgeStatus(upperResult, lowerResult);
        return getGameResultOutput();
    }
}
