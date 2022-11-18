package bridge.service;



import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static bridge.msg.InputMsg.*;

public class BridgeService {

    private BridgeGame bridgeGame = new BridgeGame();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private List<String> upside = new ArrayList<>();
    private List<String> downside = new ArrayList<>();
    private int attempt = 0;


    private List<String> upsideProgress(List<String> bridge, boolean moveSuccess) {
        if (bridge.get(upside.size()).equals(UP_MSG.getMsg()))
            upside.add(ENABLE_MSG.getMsg());
        else if (bridge.get(upside.size()).equals(UP_MSG.getMsg()) && !moveSuccess)
            upside.add(UNABLE_MSG.getMsg());

        upside.add(" ");

        return upside;
    }

    private List<String> downsideProgress(List<String> bridge, boolean moveSuccess) {
        if (bridge.get(downside.size()).equals(DOWN_MSG.getMsg()))
            downside.add(ENABLE_MSG.getMsg());
        else if (bridge.get(downside.size()).equals(DOWN_MSG.getMsg()) && !moveSuccess)
            downside.add(UNABLE_MSG.getMsg());

        downside.add(" ");

        return downside;
    }

    public int restartGame() {
        upside.clear();
        downside.clear();

        return attempt++;
    }

    public int quitGame() {
        return attempt++;
    }
}
