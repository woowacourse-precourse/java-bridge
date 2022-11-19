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

    public void setUpperBridgeResult(GameResult gameResult) {
        String upperResult = BridgeResultType.NONE.getResult();
        if (gameResult.isMoveSuccess() && gameResult.isPositionUpper()) {
            upperResult = BridgeResultType.POSSIBLE.getResult();
        } else if (!gameResult.isMoveSuccess() && gameResult.isPositionUpper()) {
            upperResult = BridgeResultType.IMPOSSIBLE.getResult();
        }
        this.upperBridge.add(upperResult);
    }

    public void setLowerBridgeResult(GameResult gameResult) {
        String lowerResult = BridgeResultType.NONE.getResult();
        if (gameResult.isMoveSuccess() && !gameResult.isPositionUpper()) {
            lowerResult = BridgeResultType.POSSIBLE.getResult();
        } else if (!gameResult.isMoveSuccess() && !gameResult.isPositionUpper()) {
            lowerResult = BridgeResultType.IMPOSSIBLE.getResult();
        }
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
        setLowerBridgeResult(gameResult);
        setUpperBridgeResult(gameResult);
        return getGameResultOutput();
    }
}
