package bridge;

import java.util.List;

public class BridgeGameController {

    public static final boolean IN_PROGRESS = true;
    public static final boolean GAME_OVER = false;

    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        System.out.println(GuidanceMessage.GAME_INTRO);
        System.out.println();

        int bridgeSize = readBridgeSize();
        List<String> bridge = makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        MovingHistory movingHistory = new MovingHistory();

        boolean inProgress = IN_PROGRESS;
        while (inProgress) {
            String moving = readMoving();
            MovingResult movingResult = bridgeGame.move(bridge, moving);
            movingHistory.save(movingResult);
            outputView.printMap(movingHistory);

            inProgress = updateGameStatus(bridgeGame, movingResult);
        }
        outputView.printResult(movingHistory, bridgeGame);
    }

    private String readMoving() {
        String moving;

        try {
            moving = inputView.readMoving();
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            return readMoving();
        }
        return moving;
    }

    private int readBridgeSize() {
        int bridgeSize;

        try {
            bridgeSize = inputView.readBridgeSize();
        } catch (IllegalArgumentException error) {
            outputView.printError(error);
            return readBridgeSize();
        }
        return bridgeSize;
    }

    private boolean updateGameStatus(BridgeGame bridgeGame, MovingResult movingResult) {
        if (movingResult.isFail() || bridgeGame.getGameResult().isSuccess()) {
            return GAME_OVER;
        }
        return IN_PROGRESS;
    }

    private List<String> makeBridge(int bridgeSize) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);

        return bridgeMaker.makeBridge(bridgeSize);
    }
}
