package enumCollections;

import bridge.Bridge;
import bridge.BridgeGame;

import java.util.List;

public enum GameResult {
    START_OF_BRIDGE("["),
    END_OF_BRIDGE("]\n"),
    EMPTY(" "),
    BRIDGE_DELIMITER("|"),
    RIGHT_POSITION("O"),
    WRONG_POSITION("X");

    private String ui;

    GameResult(String ui) {
        this.ui = ui;
    }

    public static String getUi(GameResult requiredUi) {
        return requiredUi.ui;
    }
}
