package bridge.domain;

import java.util.List;

public class Player {

    private final PlayResult playResult = new PlayResult();
    private final Bridge bridge;
    private int position = 0;

    public Player(List<String> bridge) {
        this.bridge = new Bridge(bridge);
    }

    public boolean canMove(String spaceToMove) {
        boolean moveStatus = bridge.canMove(position, spaceToMove);
        move(MoveStatus.findBySpaceToMove(spaceToMove, moveStatus));
        return moveStatus;
    }

    private void move(MoveStatus moveStatus) {
        playResult.updateResult(moveStatus);
        position++;
    }

    public void retry() {
        playResult.retry();
        position--;
    }

    public boolean crossTheBridge() {
        return bridge.isLastPosition(position);
    }

    public PlayResult getPlayResult() {
        return playResult;
    }
}
