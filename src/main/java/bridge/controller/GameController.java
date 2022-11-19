package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.domain.Tile;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임의 플래이어와 맵 등록, 입력등을 관리하는 클래스
 */
// todo: 다른 클래스로 분리할 기능들 확인
public class GameController {

    public static final String GAME_RETRY_INPUT = "R";
    public static final String GAME_QUIT_INPUT = "Q";

    private final InputView inputView;
    private final OutputView outputView;

    private BridgeGame bridgeGame;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();

        initGame();
    }

    private void initGame() {
        outputView.printGameStartMessage();
        bridgeGame = BridgeGame.from(generateRandomBridge());
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
                return Bridge.from(bridgePositions);
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
        boolean isSurvive = true;
        do {
            isSurvive = playOneTurn(player);
            outputView.printMap(bridgeGame, player);
        } while (isContinueGame(player, isSurvive));
    }

    private boolean isContinueGame(Player player, boolean isSurviveThisTurn) {
        if (isSurviveThisTurn) {
            return !bridgeGame.isWin(player);
        }
        return askForTryAgain();
    }

    private boolean playOneTurn(Player player) {
        Tile movingTargetTile = readMovingTargetTile();
        boolean turnResult = bridgeGame.move(player, movingTargetTile);
        return turnResult;
    }

    private Tile readMovingTargetTile() {
        Tile movingTile = null;
        do {
            try {
                movingTile = Tile.findByPositionSign(inputView.readMoving());
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
        outputView.printMap(bridgeGame, player);
        outputView.printResult(bridgeGame.isWin(player), player.getTryCount());
    }

}
