package bridge;

import bridge.controller.BridgeGame;
import bridge.domain.Bridge;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.domain.UserState;
import bridge.domain.enums.Command;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        try {
            outputView.printStartMessage();
            int bridgeSize = inputView.readBridgeSize();
            Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
            UserState userState = new UserState();
            gameStart(bridge, userState);
            outputView.printResult(userState, bridgeSize);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void gameStart(Bridge bridge, UserState userState) {
        while (!userState.isQuit()) {
            bridgeGame.retry(userState);
            bridgeCrossTry(bridge, userState);
            if (userState.isSuccessOrFail(bridge.getSize())) {
                return;
            }
            userState.quitChange(inputView.readGameCommand().equals(Command.QUIT.getCommand()));
        }
    }

    public static void bridgeCrossTry(Bridge bridge, UserState userState) {
        while (userState.getStep() < bridge.getSize()) {
            String userChoice = inputView.readMoving();
            boolean isSafe = bridge.isSafe(userState.getStep(), userChoice);
            bridgeGame.move(userState, isSafe, userChoice);
            outputView.printMap(userState.toString());
            if (!isSafe) {
                return;
            }
        }
    }
}
