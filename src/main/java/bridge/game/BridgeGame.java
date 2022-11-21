package bridge.game;

import bridge.generator.BridgeMaker;
import bridge.generator.BridgeRandomNumberGenerator;
import bridge.view.UserMove;
import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    private final GameCharacter character;
    private final List<String> bridge;
    private final List<Move> map = new ArrayList<>();
    private int totalTry = 0;
    private boolean success = false;

    public BridgeGame(GameCharacter character, int bridgeSize) {
        this.character = character;
        this.bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
    }

    public void moveCycle(UserMove destination) {
        character.setNextMove(destination);
        saveNextMove();
        character.move();
    }

    public void saveNextMove() {
        String destination = character.showNextDestination();
        boolean ableToMove = isAbleToMove(character.showNextArea(), destination);
        Move nextMove = makeMove(destination, ableToMove);
        map.add(nextMove);
    }

    public boolean isAbleToMove(int area, String destination) {
        return showRightDestinationInArea(area).equals(destination);
    }

    public List<String> showBridge() {
        return new ArrayList<>(bridge);
    }

    public String showRightDestinationInArea(int area) {
        return bridge.get(area);
    }

    public Move makeMove(String destination, boolean result) {
        return new Move(destination, result);
    }

    public Result moveResult() {
        int lastMoveIndex = map.size() - 1;
        if (!map.get(lastMoveIndex).isSuccess()) {
            return Result.FAIL;
        }
        if (map.size() == bridge.size()) {
            return Result.SUCCESS;
        }
        return Result.CONTINUE;
    }

    public void addTotalTry() {
        totalTry++;
    }

    public void retry() {
        map.clear();
        character.reset();
    }

    public List<Move> showCurrentMap() {
        return new ArrayList<>(map);
    }

    public void success() {
        success = true;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getResultMessage() {
        if (isSuccess()) {
            return Result.SUCCESS.getMessage();
        }
        return Result.FAIL.getMessage();
    }

    public int getTotalTry() {
        return totalTry;
    }
}
