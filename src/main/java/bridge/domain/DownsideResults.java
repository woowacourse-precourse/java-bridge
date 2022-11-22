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
            addResult(BLANK_SPACE);
        }
        if (CommandKeys.isDown(playerMove)) {
            addResult(matchResult);
        }
    }

    private void addResult(String result) {
        super.getResults()
                .add(result);
    }
}
