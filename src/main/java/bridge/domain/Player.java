package bridge.domain;

import java.util.List;

public class Player {

    private final PlayResult playResult = new PlayResult();
    private final Bridge bridge;
    private int position = 0;

    public Player(List<String> bridge) {
        this.bridge = new Bridge(bridge);
    }

    public boolean move(String spaceToMove) {
        boolean canMove = bridge.hasNextTileThatPosition(position, spaceToMove);
        move(MoveStatus.findBySpaceToMove(spaceToMove, canMove));
        return canMove;
    }

    private void move(MoveStatus moveStatus) {
        playResult.updateResult(moveStatus);
        position++;
    }

    public void deletePreviousResult() {
        playResult.deletePreviousResult();
        position--;
    }

    public boolean crossTheBridge() {
        return bridge.isLastPosition(position);
    }

    public PlayResult getPlayResult() {
        return playResult;
    }
}
