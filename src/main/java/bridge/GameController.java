package bridge;

public class GameController {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();
    private final BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private boolean gameFlag = true;
    private int count = 0;

    public void start() {
        output.printStart();
        Bridge randomBridge = makeBridge();
        BridgeGame bridgeGame = new BridgeGame(randomBridge);
        Result result = new Result();
        while (gameFlag) {
            result = gameStart(bridgeGame, randomBridge);
            count++;
        }
        output.printResult(result, count);
    }

    private Result gameStart(BridgeGame bridgeGame, Bridge randomBridge) {
        Result result = new Result();
        move(bridgeGame, randomBridge, result);
        result = restart(bridgeGame, randomBridge, result);
        gameFlag = false;
        return result;
    }

    private Result restart(BridgeGame bridgeGame, Bridge randomBridge, Result result) {
        if (!result.movable()) {
            output.printRestart();
            String command = input.readGameCommand();
            if (command.equals("R")) {
                result = gameStart(bridgeGame, randomBridge);
                count++;
            }
        }
        return result;
    }

    private void move(BridgeGame bridgeGame, Bridge randomBridge, Result result) {
        while (!randomBridge.isSize(result.nowCount()) && result.movable()) {
            play(bridgeGame, randomBridge, result);
        }
    }

    private void play(BridgeGame bridgeGame, Bridge randomBridge, Result result) {
        while (!randomBridge.isSize(result.nowCount()) && result.movable()) {
            output.printMove();
            String inputMove = input.readMoving();
            result.updateState(inputMove, bridgeGame.move(inputMove, result.nowCount()));
            output.printMap(result);
        }
    }

    private Bridge makeBridge() {
        output.printInputBridgeSize();
        while (true) {
            try {
                int bridgeSize = input.readBridgeSize();
                return new Bridge(maker.makeBridge(bridgeSize));
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
    }
}
