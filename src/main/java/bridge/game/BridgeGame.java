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
    private List<Move> moves = new ArrayList<>();

    public BridgeGame(GameCharacter character, int bridgeSize) {
        this.character = character;
        this.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
    }

    public void moveCycle(String destination) {
        character.setNextMove(destination);
        saveNextMove();
        character.move();
    }

    public void saveNextMove() {
        String destination = character.showNextDestination();
        int nextArea = character.showNextArea();
        Move move = makeMove(destination, isAbleToMove(nextArea, destination));
        moves.add(move);
    }

    public boolean isAbleToMove(int area, String destination) {
        String answer = showRightDestinationInArea(area);
        return answer.equals(destination);
    }

    public List<String> showBridge() {
        return new ArrayList<>(bridge);
    }

    public String showRightDestinationInArea(int area) {
        return showBridge().get(area);
    }

    public Move makeMove(String destination, boolean result) {
        return new Move(destination, result);
    }

    public Result moveResult() {
        int progressCount = moves.size();
        if (!moves.get(progressCount - 1).isSuccess()) {
            return Result.FAIL;
        }
        if (progressCount == bridge.size()) {
            return Result.SUCCESS;
        }
        return Result.CONTINUE;
    }

    public void addTotalTry() {
        totalTry++;
    }

    public void retry() {
        moves.clear();
        character.reset();
    }

    public List<Move> showCurrentResult() {
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
