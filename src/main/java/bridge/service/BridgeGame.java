package bridge.service;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.constant.BridgeSymbol;
import bridge.BridgeMaker;
import bridge.constant.Direction;
import bridge.model.GameResult;
import bridge.model.Map;

import java.util.Collections;
import java.util.List;

public class BridgeGame {

    private final Map map;
    private final GameResult result;

    public BridgeGame() {
        map = new Map();
        result = new GameResult();
    }

    public List<String> setBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return Collections.unmodifiableList(bridgeMaker.makeBridge(size));
    }

    public void setRound() {
        result.changeSuccess();
        result.addAttemptNumber();
        map.resetMap();
    }

    public boolean isClear() {
        return BridgeSymbol.isSuccess(result.getSuccess());
    }

    public List<String> move(String user, String answer) {
        String result = compareUserAndAnswer(user, answer);
        if (Direction.checkUp(user)) {
            map.makeUpMap(result);
        } else if (!Direction.checkUp(user)) {
            map.makeDownMap(result);
        }
        return Collections.unmodifiableList(getMap());
    }

    private String compareUserAndAnswer(String user, String answer) {
        return BridgeSymbol.isCorrect(user.equals(answer));
    }

    public boolean retry(String command) {
        return BridgeSymbol.isRetry(command);
    }

    public void changeToFail() {
        result.changeFail();
    }

    public List<String> getMap() {
        return Collections.unmodifiableList(map.getAllMap());
    }

    public List<String> getResult() {
        return Collections.unmodifiableList(
                List.of(result.getSuccess(), result.getAttemptNumber())
        );
    }
}
