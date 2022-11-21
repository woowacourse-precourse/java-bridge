package bridge.service;

import bridge.domain.Game;

public class GameService {
    public Game initializeGame() {
        return new Game(1);
    }
}
