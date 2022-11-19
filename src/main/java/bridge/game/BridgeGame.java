package bridge.game;

import bridge.generator.BridgeMaker;
import bridge.generator.BridgeRandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final GameCharacter character;
    private final List<String> bridge;

    private int totalTry = 0;
    private boolean success = false;
    private List<Progress> moves = new ArrayList<>();

    public BridgeGame(GameCharacter character, int bridgeSize) {
        this.character = character;
        this.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
    }

    public void move(String destination) {
        character.setNextMove(destination);
        saveNextMove();
        character.move();
    }

    public void saveNextMove() {
        String destination = character.showNextDestination();
        Progress progress = makeMove(destination, isAbleToMove());
        moves.add(progress);
    }

    public boolean isAbleToMove() {
        int nextArea = character.showNextArea();
        String nextMove = character.showNextDestination();
        return showRightDestinationInArea(nextArea).equals(nextMove);
    }

    public String showRightDestinationInArea(int area) {
        return bridge.get(area);
    }

    public Progress makeMove(String destination, boolean result) {
        return new Progress(destination, result);
    }

    public int moveResult() {
        int progressCount = moves.size();
        if (!moves.get(progressCount - 1).isSuccess()) {
            return Result.FAIL.getStatus();
        }
        if (progressCount == bridge.size()) {
            return Result.SUCCESS.getStatus();
        }
        return Result.CONTINUE.getStatus();
    }

    public void addTotalTry() {
        totalTry++;
    }

    public void retry() {
        moves.clear();
        character.reset();
    }

    public List<Progress> showCurrentResult() {
        return new ArrayList<>(moves);
    }

    public void success() {
        success = true;
    }

    public boolean isSuccess() {
        return success;
    }

    public String showSuccess() {
        if (success) {
            return Result.SUCCESS.getKorean();
        }
        return Result.FAIL.getKorean();
    }

    public int showTotalTry() {
        return totalTry;
    }
}
