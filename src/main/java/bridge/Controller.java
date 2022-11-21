package bridge;

import bridge.domain.BridgeGame;

import java.util.List;

public class Controller {
    private static final String QUIT_COMMAND = "Q";
    private static final String RETRY_COMMAND = "R";

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        BridgeGame bridgeGame = new BridgeGame(make());
        String command = "";
        while (!bridgeGame.isEnd() && !command.equals(QUIT_COMMAND)) {
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
        if (command.equals(RETRY_COMMAND)) {
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