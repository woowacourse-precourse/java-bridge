package bridge;

import static bridge.util.Constants.*;

import bridge.util.CommandKeys;

public class UpsideResults extends OneSideResults{

    public UpsideResults() {
        super();
    }

    @Override
    public void update(String playerMove, String matchResult) {
        if (CommandKeys.isUp(playerMove)) {
            results.add(matchResult);
        }
        if (CommandKeys.isDown(playerMove)) {
            results.add(BLANK_SPACE);
        }
    }
}
