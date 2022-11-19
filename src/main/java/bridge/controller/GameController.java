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
import java.util.function.Function;

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

    private Bridge generateRandomBridge() {
        return ValidateReader.readUntilValidate((unused -> {
            int bridgeSize = inputView.readBridgeSize();
            List<String> bridgePositions = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
            return Bridge.from(bridgePositions);
        }));
    }


    public void startGame() {
        Player player = new Player();

        playUntilEnd(player);
        showResult(player);
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

    private boolean playOneTurn(Player player) {
        Tile movingTargetTile = ValidateReader.readUntilValidate((unused) ->
                Tile.findByPositionSign(inputView.readMoving()));

        boolean turnResult = bridgeGame.move(player, movingTargetTile);
        return turnResult;
    }

    private boolean isContinueGame(Player player, boolean isSurviveThisTurn) {
        if (isSurviveThisTurn) {
            return !bridgeGame.isWin(player);
        }
        return askForTryAgain(player);
    }

    private boolean askForTryAgain(Player player) {
        String input = ValidateReader.readUntilValidate((unused) ->
                inputView.readGameCommand(GAME_RETRY_INPUT, GAME_QUIT_INPUT));

        if (input.equals(GAME_RETRY_INPUT)) {
            bridgeGame.retry(player);
            return true;
        }
        return false;
    }

    private void showResult(Player player) {
        outputView.printFinishGameInfoMessage();
        outputView.printMap(bridgeGame, player);
        outputView.printResult(bridgeGame.isWin(player), player.getTryCount());
    }

}
