package bridge.presentation;

import bridge.PlayerMap;
import bridge.data.GameMessage;

import static bridge.data.GameMark.*;

public class OutputView {
    public void printGameStart() {
        System.out.println(GameMessage.GAME_START.getMessage());
    }
}

