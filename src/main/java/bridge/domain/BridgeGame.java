package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.Instances.EndType;

import java.util.ArrayList;
import java.util.List;

import static bridge.Instances.EndType.*;
import static bridge.Instances.Setting.COMMAND_RETRY;

public class BridgeGame {

    public List<String> bridge;
    public int trial;
    public int position;
    public String lastMoving;

    public BridgeGame() {
        this.trial = 0;
        this.position = 0;
        this.bridge = new ArrayList<>();
        this.lastMoving = null;
    }

    public BridgeGame(int trial, int position, List<String> bridge, String lastMoving) {
        this.trial = trial;
        this.position = position;
        this.bridge = bridge;
        this.lastMoving = lastMoving;
    }

    public boolean isLastMovingCorrect() {
        return bridge.get(position - 1).equals(lastMoving);
    }

    public boolean gameSuccess() {
        return ((position == bridge.size()) && isLastMovingCorrect());
    }

    public void initialize() {
        trial = 1;
        position = 0;
    }

    public void setBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);
        Validation.correctSize(size, bridge);
        this.bridge = bridge;
    }

    public void move(String moving) {
        lastMoving = moving;
        position++;
    }

    public EndType retry(String input) {
        if (input.equals(COMMAND_RETRY)) {
            trial++;
            position = 0;
            return FAIL_RETRY;
        }
        return FAIL_QUIT;
    }
}
