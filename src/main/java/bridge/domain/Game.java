package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<String> directions;
    private int totalAttempts;
    private List<Bridge> bridges;
    private boolean finalResult;

    public Game(int bridgeSize) {
        this.directions = generateDirections(bridgeSize);
        this.totalAttempts = 0;
        this.bridges = new ArrayList<>();
        this.finalResult = false;
    }

    public List<String> generateDirections(int bridgeSize) {
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public void increaseAttempt() {
        this.totalAttempts++;
    }

    public List<String> getDirections() {
        return directions;
    }

    public int getTotalAttempts() {
        return totalAttempts;
    }

    public List<Bridge> getBridges() {
        return bridges;
    }

    public boolean checkFinalResult() {
        return finalResult;
    }

    public void setBridges(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public void setFinalResult(boolean finalResult) {
        this.finalResult = finalResult;
    }
}
