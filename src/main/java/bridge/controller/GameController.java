package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.Tile;
import bridge.domain.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    public static final String GAME_RETRY_INPUT = "R";
    public static final String GAME_QUIT_INPUT = "Q";

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;

    private final Bridge bridge;

    public GameController() {
        bridgeGame = new BridgeGame();
        inputView = new InputView();
        outputView = new OutputView();

        outputView.printGameStartMessage();
        bridge = generateRandomBridge();
    }

    public void startGame() {
        Player player = new Player();

        playUntilEnd(player);
        showResult(player);
    }

    private Bridge generateRandomBridge() {
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                List<String> bridgePositions = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
                Bridge bridge = Bridge.from(bridgePositions);
                return bridge;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    /**
     * End if player die and select quit game or clear the game
     *
     * @param player 게임 플래이어
     */
    private void playUntilEnd(Player player) {
        boolean isSurvival = true;
        do {
            isSurvival = playOneTurn(player);
            outputView.printMap(bridge, player);
        } while (isContinueGame(player, isSurvival));
    }

    private boolean isContinueGame(Player player, boolean isSurvivalThisTurn) {
        if (isSurvivalThisTurn) {
            return !bridgeGame.isWin(bridge, player);
        }
        return askForTryAgain();
    }

    private boolean playOneTurn(Player player) {
        Tile movingTargetTile = readMovingTargetTile();
        boolean turnResult = bridgeGame.move(bridge, player, movingTargetTile);
        return turnResult;
    }

    private Tile readMovingTargetTile() {
        Tile movingTile = null;
        do {
            try {
                movingTile = Tile.findByTilePosition(inputView.readMoving());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        } while (movingTile == null);

        return movingTile;
    }

    private boolean askForTryAgain() {
        String input = readTryAgainInput();
        if (input.equals(GAME_RETRY_INPUT)) {
            return true;
        }
        return false;
    }

    private String readTryAgainInput() {
        String input = null;
        do {
            try {
                input = inputView.readGameCommand(GAME_RETRY_INPUT, GAME_QUIT_INPUT);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        } while (input == null);

        return input;
    }

    private void showResult(Player player) {
        outputView.printFinishGameInfoMessage();
        outputView.printMap(bridge, player);
        outputView.printResult(bridgeGame.isWin(bridge, player), player.getTryCount());
    }

}
