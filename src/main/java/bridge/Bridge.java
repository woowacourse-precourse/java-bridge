package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridges;
    private final List<String> user = new ArrayList<>();
    private final List<ResultSymbol> upLine = new ArrayList<>();
    private final List<ResultSymbol> downLine = new ArrayList<>();
    private int crossingCount = 0;

    public Bridge(List<String> bridges) {
        this.bridges = bridges;
    }

    public ResultSymbol move(String moveCommand) {
        user.add(moveCommand);
        crossingCount = user.size() - 1;
        save(moveCommand);
        return isCrossing(moveCommand);
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
        if (bridges.get(crossingCount).equals(moveCommand)) {
            return ResultSymbol.SUCCESS;
        }
        return ResultSymbol.FAIL;
    }

    public List<ResultSymbol> getUpLine() {
        return upLine;
    }

    public List<ResultSymbol> getDownLine() {
        return downLine;
    }

    public int getCount() {
        return bridges.size();
    }

    public int getCrossingCount() {
        return crossingCount + 1;
    }
}
