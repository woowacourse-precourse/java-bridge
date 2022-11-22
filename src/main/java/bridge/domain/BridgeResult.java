package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class BridgeResult {

    private final Bridge bridge;
    private final List<ResultSymbol> upLine = new ArrayList<>();
    private final List<ResultSymbol> downLine = new ArrayList<>();
    private int crossingCount = 0;

    public BridgeResult(Bridge bridge) {
        this.bridge = bridge;
    }

    public ResultSymbol move(String moveCommand) {
        save(moveCommand);
        ResultSymbol isCross = isCrossing(moveCommand);
        crossingCount++;
        return isCross;
    }

    private void save(String moveCommand) {
        if (moveCommand.equals("U")) {
            upLine.add(isCrossing(moveCommand));
            downLine.add(ResultSymbol.NOTHING);
        }
        if (moveCommand.equals("D")) {
            upLine.add(ResultSymbol.NOTHING);
            downLine.add(isCrossing(moveCommand));
        }
    }

    private ResultSymbol isCrossing(String moveCommand) {
        List<String> bridges = bridge.getBridges();
        if (bridges.get(crossingCount).equals(moveCommand)) {
            return ResultSymbol.SUCCESS;
        }
        return ResultSymbol.FAIL;
    }

    public String getUpLine() {
        return conversionResult(upLine);
    }

    public String getDownLine() {
        return conversionResult(downLine);
    }

    private String conversionResult(List<ResultSymbol> lines) {
        String str = "[ ";
        for (int i=0; i<lines.size(); i++) {
            if (i != 0) {
                str += " | ";
            }
            str += lines.get(i).getSymbol();
        }
        str += " ]";
        return str;
    }

    public int getCrossingCount() {
        return crossingCount;
    }

    public void reset() {
        upLine.clear();
        downLine.clear();
        crossingCount = 0;
    }
}
