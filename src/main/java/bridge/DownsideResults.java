package bridge;

import bridge.util.CommandKeys;

public class DownsideResults extends OneSideResults{
    public DownsideResults() {
        super();
    }

    @Override
    public void updateResults(String currentMove, String moveResult, String blankSpace) {
        if (CommandKeys.isDown(currentMove)) {
            results.add(moveResult);
        }
        if (CommandKeys.isUp(currentMove)) {
            results.add(blankSpace);
        }
    }
}
