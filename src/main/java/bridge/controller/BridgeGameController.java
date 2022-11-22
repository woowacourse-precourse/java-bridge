package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.Game;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private static final String RESTART = "R";
    private static final String QUIT = "Q";
    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Game game = new Game();
        outputView.printBridgeGameStartMessage();
        int bridgeLength = askBridgeLengthInput();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(bridgeLength));
        gameStart(bridge, game);
    }

    public void gameStart(Bridge bridge, Game game) {
        while (!game.isGameDone()) {
            String userMove = askHowUserMoves();
            outputView.printNowMap(bridge.getNowIndex(), userMove, bridge.isSameValueOfComputerAndUser(userMove));
            determineUserValueIsEqualToComputerValue(bridge, game, userMove);
        }
        outputView.printResult(game);
    }



}