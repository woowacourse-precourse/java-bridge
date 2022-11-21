package bridge.domain;

import static bridge.util.Constants.BLANK_SPACE;

import bridge.util.CommandKeys;

public class DownsideResults extends OneSideResults {

    public DownsideResults() {
        super();
    }

    @Override
    public void update(String playerMove, String matchResult) {
        if (CommandKeys.isUp(playerMove)) {
            super.getResults().add(BLANK_SPACE);
        }
        if (CommandKeys.isDown(playerMove)) {
            super.getResults().add(matchResult);
        }
    }

    @Override
    public void reset() {
        super.getResults().clear();
    }
}
