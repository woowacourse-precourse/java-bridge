package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.domain.Tile;
import bridge.util.RepeatValidator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임의 플래이어와 맵 등록, 입력등을 관리하는 클래스
 */
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
        bridgeGame = generateRandomBridgeGame();
        outputView.printEmptyLine();
    }

    private BridgeGame generateRandomBridgeGame() {
        return RepeatValidator.readUntilValidate(() -> {
            int bridgeSize = inputView.readBridgeSize();
            BridgeMaker randomBridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridgeDirections = randomBridgeMaker.makeBridge(bridgeSize);

            return BridgeGame.from(bridgeDirections);
        });
    }


    public void startGame() {
        Player player = new Player();

        playUntilEnd(player);
        showResult(player);
    }

    private void playUntilEnd(Player player) {
        while (isContinueGame(player)) {
            playOneTurn(player);
            outputView.printMap(bridgeGame, player);
        }
    }

    private void playOneTurn(Player player) {
        Tile movingTargetTile = RepeatValidator.readUntilValidate(() ->
                Tile.findByDirectionSign(inputView.readMoving()));

        bridgeGame.move(player, movingTargetTile);
    }

    private boolean isContinueGame(Player player) {
        if (player.isAlive()) {
            return !bridgeGame.isWin(player);
        }
        return decideTryAgainOrNot(player);
    }

    private boolean decideTryAgainOrNot(Player player) {
        String input = RepeatValidator.readUntilValidate(() ->
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
