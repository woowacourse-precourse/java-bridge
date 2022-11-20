package bridge.generator;

public class FailBridgeStringGenerator extends BridgeStringGenerator {
    @Override
    public String makeLastFigure(String footprintDirection, String checkDirection) {
        if (footprintDirection.equals(checkDirection)) return "X";
        return " ";
    }
}
