package bridge.model;

public class BridgeGame {
    private final Round round;
    private final PassingSpace passingSpace;
    private int numberOfTry;

    public BridgeGame(Round round, PassingSpace passingSpace) {
        this.round = round;
        this.passingSpace = passingSpace;
        numberOfTry = 1;
    }

    private void reset() {
        passingSpace.reset();
        round.reset();
    }

    public void move(String selectedSpace) {
        Space space = Space.valueOf(selectedSpace);
        Movable movable = round.canMovable(selectedSpace);
        passingSpace.add(space, movable);
        round.next();
    }

    public String drawPassingSpace() {
        return passingSpace.toString();
    }

    public boolean selectRightSpace() {
        return round.isSuccessSelectingRightSpace();
    }

    public boolean isSuccessCrossingBridge() {
        return round.isSuccessLastRound();
    }

    public boolean retry(String selectRetry) {
        Retry retry = Retry.valueOf(selectRetry);

        if (retry.isRetry()) {
            numberOfTry += 1;
            reset();
        }
        return retry.isRetry();
    }

    public GameResultDto getGameResult() {
        String passingSpace = drawPassingSpace();
        boolean isSuccess = isSuccessCrossingBridge();
        return new GameResultDto(passingSpace, isSuccess, numberOfTry);
    }
}