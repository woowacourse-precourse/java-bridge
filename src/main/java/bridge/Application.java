package bridge;

import bridge.BridgeGame.STATE;

public class Application {
    public static void makeOneStep(BridgeGame game, InputView inputView, OutputView outputView) {
        String moving = inputView.readMoving();
        game.move(moving);
        outputView.printMap(game.getBridge(), game.getMoves());
    }

    public static BridgeGame gameProcess(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        BridgeGame game = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        while (game.getState() == STATE.MOVING) {
            makeOneStep(game, inputView, outputView);
            if (game.getState() == STATE.FAILED) {
                String command = inputView.readGameCommand();
                game.retry(command);
            }
        }
        return game;
    }

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        try {
            BridgeGame game = gameProcess(bridgeMaker, inputView, outputView);
            outputView.printResult(game);
        } catch (IllegalArgumentException exception) {
            System.out.printf("[ERROR] %s", exception.getMessage());
        }
    }
}
