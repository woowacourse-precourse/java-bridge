package bridge.service;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static bridge.msg.InputMsg.*;

public class BridgeService {

    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame = new BridgeGame();
    private List<String> upside = new ArrayList<>();
    private List<String> downside = new ArrayList<>();
    private int index = 0;


    public List<String> bridgeMake(int size) {
        return bridgeMaker.makeBridge(size);
    }

    public boolean isMove(String inputMove, List<String> bridge) {
        return bridgeGame.move(inputMove, bridge, index);
    }

    public List<List<String>> upAndDownProgress(String inputMove, boolean isMove) {
        List<List<String>> upAndDown = new ArrayList<>();

        if (inputMove.equals(UP_MSG.getMsg())) upProgress(isMove);
        else if (inputMove.equals(DOWN_MSG.getMsg())) downProgress(isMove);

        upAndDown.add(upside);
        upAndDown.add(downside);

        return upAndDown;
    }

    private void upProgress(boolean isMove) {
        if (isMove) {
            upside.add(ENABLE_MSG.getMsg());
        } else if (!isMove) {
            upside.add(UNABLE_MSG.getMsg());
        }
        downside.add(" ");

        index++;
    }

    private void downProgress(boolean isMove) {
        if (isMove) {
            downside.add(ENABLE_MSG.getMsg());
        } else if (!isMove) {
            downside.add(UNABLE_MSG.getMsg());
        }
        upside.add(" ");

        index++;
    }

    private void cleanSide() {
        upside.clear();
        downside.clear();
    }

    public boolean retryJudge(String inputRetry) {
        if (inputRetry.equals(RESTART_MSG.getMsg())) {
            cleanSide();
            index = 0;
            return true;
        }

        return false;
    }
}
