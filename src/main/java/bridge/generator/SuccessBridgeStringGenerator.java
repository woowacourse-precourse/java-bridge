package bridge.generator;

public class SuccessBridgeStringGenerator extends BridgeStringGenerator {
    @Override
    public String makeLastFigure(String footprintDirection, String checkDirection) {
        return makeCircleString(footprintDirection, checkDirection);
    }
}
