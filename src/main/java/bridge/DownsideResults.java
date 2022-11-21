package bridge;

import static bridge.util.Constants.*;

import bridge.util.CommandKeys;

public class DownsideResults extends OneSideResults{
    public DownsideResults() {
        super();
    }

    @Override
    public void update(String playerMove, String matchResult) {
        if (CommandKeys.isUp(playerMove)) {
            results.add(BLANK_SPACE);
        }
        if (CommandKeys.isDown(playerMove)) {
            results.add(matchResult);
        }
    }
}
