package bridge;

import constant.Values.MoveCase;
import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private Checker checker = new Checker();
    private List<String> bridge;
    private List<String> moves;
    private List<MoveCase> results;
    private int index;
    private int gameTry;

    public BridgeGame(int size) {
        size = checker.checkNegative(size);
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = bridgeMaker.makeBridge(size);
        moves = new ArrayList<>();
        results = new ArrayList<>();
        index = 0;
        gameTry = 1;
    }

    public void move(String move) {
        moves.add(move);
        MoveCase moveCase = checker.checkMoveSuccess(bridge.get(index), move);
        results.add(moveCase);
        index += 1;
    }

    public void retry() {
        moves = new ArrayList<>();
        results = new ArrayList<>();
        index = 0;
        gameTry += 1;
    }

    public List<String> getBridge() {
        return bridge;
    }

    public List<MoveCase> getResults() {
        return results;
    }

    public int getIndex() {
        return index;
    }

    public int getGameTry() {
        return gameTry;
    }
}
