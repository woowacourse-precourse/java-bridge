package bridge;

import bridge.domain.BridgeGame;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        BridgeGame bridgeGame = new BridgeGame(make());
        String command = "";
        while (!bridgeGame.isEnd() && !command.equals("Q")) {
            move(bridgeGame);
            if (!bridgeGame.isMovableArea()) {
                command = checkReset(bridgeGame);
            }
        }
        outputView.printResult(bridgeGame);
    }

    private String checkReset(BridgeGame bridgeGame) {
        String command;

        command = inputView.readGameCommand();
        if (command.equals("R")) {
            bridgeGame.retry();
        }
        return command;
    }
    public List<String> make() {
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
                return bridgeMaker.makeBridge(bridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public void move(BridgeGame bridgeGame) {
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getPlayer());
    }
}