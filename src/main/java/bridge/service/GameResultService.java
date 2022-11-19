package bridge.service;

import bridge.domain.BridgeResult;

import java.util.ArrayList;

public class GameResultService {

    public static BridgeResult initGameResult() {
        return new BridgeResult(new ArrayList<>(), new ArrayList<>());
    }
}
