package bridge.gameplay;

import static bridge.gameplay.GameState.*;
import static bridge.output.MessageForOutput.*;

import bridge.input.InputView;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.output.OutputView;
import java.util.List;

public class GamePlay {

    BridgeGame bridgeGame;
    InputView inputView;
    OutputView outputView;

    public GamePlay() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void play() {
        printGameStart();
        createBridgeGame();

        GameState gameState = MOVABLE;
        while (gameState != GAME_END) {
            gameState = playingGame(gameState);
        }

        printGameResult();
    }
    private void printGameStart() {
        System.out.print(GAME_START.getMessage());
        System.out.print("\n\n");
    }
    private void createBridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        printRequireSize();
        List<String> answerBridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        bridgeGame = new BridgeGame(answerBridge);
        System.out.print("\n");
    }
    private void printRequireSize() {
        System.out.print(REQUIRE_SIZE.getMessage());
        System.out.print("\n");
    }

    private GameState playingGame(GameState gameState) {
        if (gameState == MOVABLE) {
            return movable();
        }
        if (gameState == FAIL_TO_MOVE) {
            return failToMove();
        }
        return GAME_END;
    }
    private GameState movable() {
        printRequireWhereToMove();
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getBridgeTrack(), bridgeGame.getAnswerBridge());
        return gameStateAfterMoving();
    }
    private void printRequireWhereToMove() {
        System.out.print(REQUIRE_WHERE_TO_MOVE.getMessage());
        System.out.print("\n");
    }
    private GameState gameStateAfterMoving() {
        if (!bridgeGame.isRecentMoveSuccessful()) {
            return FAIL_TO_MOVE;
        }
        if (bridgeGame.isBridgeGameSuccess()) {
            return GAME_END;
        }
        return MOVABLE;
    }
    private GameState failToMove() {
        printWantToRetry();
        String input = inputView.readGameCommand();
        if (isWantToRetry(input)) {
            bridgeGame.retry();
            return MOVABLE;
        }
        return GAME_END;
    }
    private void printWantToRetry() {
        System.out.print(REQUIRE_WANT_TO_RETRY.getMessage());
        System.out.print("\n");
    }
    private boolean isWantToRetry(String input) {
        return input.equals(RETRY_COMMAND);
    }

    private void printGameResult() {
        outputView.printResult(bridgeGame.getBridgeTrack(), bridgeGame.getAnswerBridge(), bridgeGame.getTryCount());
    }
}

