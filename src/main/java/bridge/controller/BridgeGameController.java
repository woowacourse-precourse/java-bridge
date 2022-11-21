package bridge.controller;

import bridge.domain.Player;
import bridge.domain.Victory;
import bridge.dto.GameMoveDto;
import bridge.dto.GameResultDto;
import bridge.service.BridgeGameService;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.function.Supplier;

public class BridgeGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private final BridgeGameService bridgeGameService;

    public BridgeGameController(BridgeGameService bridgeGameService) {
        this.bridgeGameService = bridgeGameService;
    }

    public void run() {
        initializeBridge();
        Player player = crossBridge(new Player());
        printGameResult(player);
    }

    private void initializeBridge() {
        outputView.printGameStart();
        int size = repeat(inputView::readBridgeSize);
        bridgeGameService.initializeBridgeGame(size);
    }

    private Player crossBridge(Player player) {
        while (bridgeGameService.isPlayable()) {
            playerMove(player);
            checkRetry(player);
        }
        return player;
    }

    private void playerMove(Player player) {
        String move = repeat(inputView::readMoving);
        GameMoveDto gameMoveDto = bridgeGameService.play(player, move);
        outputView.printMap(gameMoveDto);
    }

    private void checkRetry(Player player) {
        if (isGameOver(player) || bridgeGameService.isPlayable()) {
            return;
        }
        String command = repeat(inputView::readGameCommand);
        bridgeGameService.retry(player, command);
    }

    private boolean isGameOver(Player player) {
        Victory result = player.checkGamePassed();
        return !bridgeGameService.isPlayable() && result.isVictory();
    }

    private void printGameResult(Player player) {
        GameResultDto gameResultDto = bridgeGameService.gameOver(player);
        outputView.printResult(gameResultDto);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return repeat(inputReader);
        }
    }
}
