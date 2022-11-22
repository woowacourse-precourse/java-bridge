package bridge.ui.output.dto;

import bridge.ui.ConsolePrintable;
import bridge.ui.output.PrintText;

public class BridgeGameResult implements ConsolePrintable {
    private static final String LINE_BREAK = "\n";
    private final String bridgeGameMap;
    private final boolean isClearGame;
    private final int trial;

    public BridgeGameResult(String bridgeGameMap, boolean isClearGame, int trial) {
        this.bridgeGameMap = bridgeGameMap;
        this.isClearGame = isClearGame;
        this.trial = trial;
    }

    @Override
    public String toConsolePrintFormat() {
        return new StringBuilder(this.bridgeGameMap)
                .append(LINE_BREAK).append(LINE_BREAK)
                .append(clearToString())
                .append(LINE_BREAK)
                .append(trialToString())
                .toString();
    }

    private String clearToString() {
        if (isClearGame) {
            return PrintText.GAME_CLEAR_TEXT.toConsolePrintFormat();
        }

        return PrintText.GAME_FAIL_TEXT.toConsolePrintFormat();
    }

    private String trialToString() {
        return PrintText.GAME_TRIAL_TEXT.toConsolePrintFormat() + trial;
    }
}
