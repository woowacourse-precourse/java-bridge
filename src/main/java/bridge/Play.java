package bridge;

public class Play {
    private static final String RETRY_COMMAND = "R";

    private final View view;
    private final BridgeGame bridgeGame;
    private final Map map;

    public Play() {
        this.view = new View();
        this.bridgeGame = start();
        this.map = new Map();
    }

    private BridgeGame start() {
        int bridgeSize = view.gameStartView();

        return new BridgeGame(bridgeSize);
    }

    private void round() {
        String moving = view.moveView();
        bridgeGame.move(moving);
        map.drawMap(bridgeGame.getUserPath(), bridgeGame.isCorrectPath());
        view.mapView(map.getMap());
        checkRetry();
        nextRound();
    }

    private void checkRetry() {
        if (!bridgeGame.isCorrectPath()) {
            String retryCommand = view.retryView();
            if (retryCommand.equals(RETRY_COMMAND)) {
                bridgeGame.retry(map);
                round();
            }
        }
    }

    private void nextRound() {
        if (bridgeGame.isCorrectPath() && bridgeGame.getUserPosition() < bridgeGame.getBridgeSize() - 1) {
            round();
        }
    }

    private void finish() {
        view.closeView(
                map.getMap(),
                bridgeGame.getTryCount(),
                bridgeGame.isCorrectPath()
        );
    }

    public void play() {
        round();
        finish();
    }
}
