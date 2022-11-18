package bridge.Domain;

import bridge.EnumCollections.BridgeResultType;
import bridge.EnumCollections.BridgeType;

import java.util.ArrayList;
import java.util.List;

public class GameResultGenerator {
    private List<String> upperBridge;
    private List<String> lowerBridge;

    public GameResultGenerator() {
        this.upperBridge = new ArrayList<>();
        this.lowerBridge = new ArrayList<>();
    }

    public void setUpperBridgeResult(GameResult gameResult) {
        String upperResult = BridgeResultType.NONE.getResult();
        if (gameResult.isGameSuccess() && gameResult.isPositionUpper()) {
            upperResult = BridgeResultType.POSSIBLE.getResult();
        } else if (!gameResult.isGameSuccess() && gameResult.isPositionUpper()) {
            upperResult = BridgeResultType.IMPOSSIBLE.getResult();
        }
        this.upperBridge.add(upperResult);
    }

    public void setLowerBridgeResult(GameResult gameResult) {
        String lowerResult = BridgeResultType.NONE.getResult();
        if (gameResult.isGameSuccess() && !gameResult.isPositionUpper()) {
            lowerResult = BridgeResultType.POSSIBLE.getResult();
        } else if (!gameResult.isGameSuccess() && !gameResult.isPositionUpper()) {
            lowerResult = BridgeResultType.IMPOSSIBLE.getResult();
        }
        this.lowerBridge.add(lowerResult);
    }

    public String getGameResult() {
        String upBridge = makeBridgeOutput(this.upperBridge);
        String lowBridge = makeBridgeOutput(this.lowerBridge);
        return upBridge + '\n' + lowBridge;
    }

    public String makeBridgeOutput(List<String> bridge) {
        return"[ " + String.join(" | ", bridge) + " ]";
    }

}
