package bridge;

import java.util.List;

public class Player {
    private final InputView input;
    private final OutputView output;
    private int bridgeSize;
    private boolean run;
    private int playCount = 0;
    private List<Map> mapResult;

    public Player(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public BridgeGame start() {
        output.startMessage();
        bridgeSize = input.readBridgeSize();
        return new BridgeGame(bridgeSize);
    }

    public void play(BridgeGame bridgeGame) {
        playCount++;
        for (int index = 0; index < bridgeSize; index++) {
            while (run) {
                String moving = input.readMoving();
                String moveResult = bridgeGame.move(moving, index);
                makeMap(moveResult, moving, index);
                output.printMap(mapResult);
                continueOrRetry(moveResult, bridgeGame);
            }
        }

    }

    public void continueOrRetry(String moveResult, BridgeGame bridgeGame) {
        if (moveResult.equals("X")) {
            String gameCommand = input.readGameCommand();
            if (gameCommand.equals("R")) {
                bridgeGame.retry();
                return;
            }
            output.printResult(mapResult);
        }
    }

    public void makeMap(String moveResult, String moving, int index) {
        if (moving.equals("U")) {
            mapResult.add(index, new Map(moveResult, null));
            return;
        }
        mapResult.add(index, new Map(null, moveResult));
    }

    public List<Map> getMap() {
        return mapResult;
    }

}
