package bridge.domain;

import bridge.constant.GameCommand;
import bridge.constant.MoveCommand;

import static bridge.constant.MoveSign.MOVE_FAIL;
import static bridge.constant.MoveSign.MOVE_SUCCESS;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private static final String GAME_SUCCESS = "성공";
    private static final String GAME_FAIL = "실패";

    private final Bridge bridge;
    private final Player player;
    private final BridgeGameResults bridgeGameResults = new BridgeGameResults();

    private String gameResult = GAME_SUCCESS;

    public BridgeGame(final Bridge bridge, final Player player) {
        this.bridge = bridge;
        this.player = player;
    }
    public boolean isNotOver(final GameCommand gameCommand) {
        return !gameCommand.is(GameCommand.QUIT) && playerIsOnTheBridge();
    }

    private boolean playerIsOnTheBridge() {
        return player.isOnTheBridge(bridge);
    }

    public String bridgeGameResult(MoveCommand moveCommand) {
        if (bridge.isMatched(player, moveCommand)) {
            return MOVE_SUCCESS.getMessage();
        }
        return MOVE_FAIL.getMessage();
    }

    public BridgeGameResults bridgeGameResults(MoveCommand moveCommand, String gameResult) {
        bridgeGameResults.addResults(moveCommand, gameResult);
        return bridgeGameResults;
    }

    public void move(String moveResult) {
        if (moveResult.equals(MOVE_SUCCESS.getMessage())) {
            player.move();
        }
    }

    public void retryOrQuit(GameCommand gameCommand) {
        if (gameCommand.is(GameCommand.RETRY)) {
            retry();
            return;
        }

        this.gameResult = GAME_FAIL;
    }

    private void retry() {
        bridgeGameResults.reset();
        player.resetPosition();
        player.increaseChallenges();
    }

    public BridgeGameResults bridgeGameResults() {
        return bridgeGameResults;
    }

    public int totalChallengeNumbers() {
        return player.challengeNumbers();
    }

    public String gameResult() {
        return gameResult;
    }
}
