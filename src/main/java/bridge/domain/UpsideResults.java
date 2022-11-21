package bridge.domain;

import static bridge.util.Constants.BLANK_SPACE;

import bridge.util.CommandKeys;

public class UpsideResults extends OneSideResults {

    public UpsideResults() {
        super();
    }

    @Override
    public void update(String playerMove, String matchResult) {
        if (CommandKeys.isUp(playerMove)) {
            super.getResults().add(matchResult);
        }
        if (CommandKeys.isDown(playerMove)) {
            super.getResults().add(BLANK_SPACE);
        }
    }

    @Override
    public void reset() {
        super.getResults().clear();
    }
}
