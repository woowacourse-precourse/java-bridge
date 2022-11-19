package bridge.service;

import bridge.domain.GameResult;

import java.util.ArrayList;

public class GameResultService {

    public static GameResult initGameResult() {
        return new GameResult(new ArrayList<>(), new ArrayList<>());
    }
}
