package bridge;

import bridge.util.CommandKeys;

public class UpsideResults extends OneSideResults{

    public UpsideResults() {
        super();
    }

    @Override
    public void updateResults(String currentMove, String moveResult, String blankSpace) {
        if (CommandKeys.isUp(currentMove)) {
            results.add(moveResult);
        }
        if (CommandKeys.isDown(currentMove)) {
            results.add(blankSpace);
        }
    }
}
