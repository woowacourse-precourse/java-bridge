package bridge.domain;

public class Player {

    private final PlayResult playResult = new PlayResult();
    private int position = 0;

    public boolean canMove(Bridge bridge, String spaceToMove) {
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

    public boolean crossTheBridge(int bridgeSize) {
        return position == bridgeSize;
    }

    public PlayResult getPlayResult() {
        return playResult;
    }
}
