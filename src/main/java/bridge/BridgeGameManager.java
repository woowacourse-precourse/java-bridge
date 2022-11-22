package bridge;

import bridge.constant.command.GameCommand;
import bridge.model.BridgeRoadMap;
import bridge.model.UserRoadMap;
import java.util.ArrayList;

public class BridgeGameManager {
    private int trialCount;
    private BridgeRoadMap bridgeRoadMap;

    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    private final BridgeMaker bridgeMaker;
    private final UserRoadMap userRoadMap;
    private final BridgeGame game;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameManager() {
        trialCount = 0;

        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        userRoadMap = new UserRoadMap(new ArrayList<>());
        game = new BridgeGame(userRoadMap);

        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        try {
            initialize();
            do {
                trialCount++;
                run();
            } while (bridgeRoadMap.isFail(userRoadMap) && isRetry());
            finish();
        } catch (Exception e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    private void initialize() {
        outputView.printGameStart();

        outputView.printInputBridgeSize();
        InfiniteInput<Integer> bridgeSizeInfiniteInput = new InfiniteInput<>(0);
        int bridgeSize = bridgeSizeInfiniteInput.getInput(() -> inputView.readBridgeSize(), outputView);
        outputView.printNextLine();

        bridgeRoadMap = new BridgeRoadMap(bridgeMaker.makeBridge(bridgeSize));
    }

    private void run() {
        do {
            outputView.printInputMove();
            InfiniteInput<String> directionInfiniteInput = new InfiniteInput<>("");
            String direction = directionInfiniteInput.getInput(() -> inputView.readMoving(), outputView);
            game.move(direction);

            outputView.printMap(bridgeRoadMap, userRoadMap);
        } while (!(bridgeRoadMap.isFail(userRoadMap) || bridgeRoadMap.isEnd(userRoadMap)));
    }

    private boolean isRetry() {
        outputView.printInputRetry();
        InfiniteInput<String> commandInfiniteInput = new InfiniteInput<>("");
        String command = commandInfiniteInput.getInput(() -> inputView.readGameCommand(), outputView);

        if (command.equals(GameCommand.RETRY.getValue())) {
            game.retry();
            return true;
        }
        return false;
    }

    private void finish() {
        outputView.printResult(trialCount, bridgeRoadMap, userRoadMap);
    }
}
