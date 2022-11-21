package bridge.domain;

import static bridge.util.Constants.BLANK_SPACE;

import bridge.util.CommandKeys;

public class UpsideResults extends OneSideResults {

    public UpsideResults() {
        super();
    }

    public void update(String playerMove, String matchResult) {
        if (CommandKeys.isUp(playerMove)) {
            super.getResults().add(matchResult);
        }
        if (CommandKeys.isDown(playerMove)) {
            super.getResults().add(BLANK_SPACE);
        }
    }

    public void reset(String input) {
        if (CommandKeys.isRetry(input)) {
            initialize();
        }
    }

    private void initialize() {
        super.getResults().clear();
    }
}
