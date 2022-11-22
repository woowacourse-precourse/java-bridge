package bridge;

public class BridgeGame {
    private final Bridge gameBridge;
    private User user;
    private Integer userTry = 1;

    BridgeGame(Integer size) {
        BridgeMaker bm = new BridgeMaker(new BridgeRandomNumberGenerator());
        gameBridge = new Bridge(bm.makeBridge(size));
        user = new User();
    }

    public void move(String input) {
        user.crossingBlock(input);
        user.drawMap(gameBridge);
    }

    public String lastMoveToString() {
        return user.mapToString();
    }

    public void retry(String input) {
        if (isQuit(input)) {
            return;
        } else if (isRetry(input)) {
            user = new User();
            userTry++;
        }
    }

    private boolean isQuit(String input) {
        return (input.equals("q") || input.equals("Q"));
    }

    private boolean isRetry(String input) {
        return (input.equals("r") || input.equals("R"));
    }

    public int userTry() {
        return userTry;
    }

    public boolean isCorrect() {
        return user.isMoveSucceed() && user.isMoveFinished();
    }

    public boolean isGameOver() {
        return !user.isMoveSucceed();
    }
}
