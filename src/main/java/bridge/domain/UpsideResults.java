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
            addResult(matchResult);
        }
        if (CommandKeys.isDown(playerMove)) {
            addResult(BLANK_SPACE);
        }
    }

    private void addResult(String result) {
        super.getResults()
                .add(result);
    }
}
