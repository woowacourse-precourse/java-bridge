package bridge.domain.bridge_game;

import static bridge.domain.constants.GameCommands.QUIT;
import static bridge.domain.constants.GameCommands.RETRY;
import static bridge.domain.constants.MoveResultsSign.MOVE_FAIL;
import static bridge.domain.constants.MoveResultsSign.MOVE_SUCCESS;

import bridge.domain.constants.GameCommands;
import bridge.domain.constants.MoveCommands;

public class BridgeGame {

    private static final String GAME_SUCCESS = "성공";
    private static final String GAME_FAIL = "실패";

    private final Bridge bridge;
    private final Player player;
    private final MoveResults moveResults;
    private String gameResult = GAME_SUCCESS;

    public BridgeGame(final Bridge bridge, final Player player, final MoveResults moveResults) {
        this.bridge = bridge;
        this.player = player;
        this.moveResults = moveResults;
    }

    public boolean isNotOver(final GameCommands gameCommand) {
        return !gameCommand.is(QUIT) && playerIsOnTheBridge();
    }

    private boolean playerIsOnTheBridge() {
        return player.isOnTheBridge(bridge);
    }

    public String moveResult(final MoveCommands moveCommand) {
        if (bridge.isMatched(player, moveCommand)) {
            return MOVE_SUCCESS;
        }

        return MOVE_FAIL;
    }

    public MoveResults moveResults(final MoveCommands moveCommand, final String moveResult) {
        moveResults.addResults(moveCommand, moveResult);
        return moveResults;
    }

    public void move(final String moveResult) {
        if (moveResult.equals(MOVE_SUCCESS)) {
            player.move();
        }
    }

    public void retryOrQuit(final GameCommands gameCommand) {
        if (gameCommand.is(RETRY)) {
            retry();
            return;
        }

        this.gameResult = GAME_FAIL;
    }

    private void retry() {  // TODO 혹시 제출 테스트 케이스 실패하면 여기의 private를 의심하렴..
        moveResults.reset();
        player.resetPosition();
        player.increaseChallenges();
    }

    public MoveResults moveResults() {
        return moveResults;
    }

    public int totalNumberOfChallenges() {
        return player.numberOfChallenges();
    }

    public String gameResult() {
        return gameResult;
    }
}
