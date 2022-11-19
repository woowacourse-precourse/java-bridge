package bridge.domain;

import static bridge.domain.constants.GameCommands.RETRY;
import static bridge.domain.constants.MoveResultsSign.MOVE_FAIL;
import static bridge.domain.constants.MoveResultsSign.MOVE_SUCCESS;

import bridge.domain.constants.GameCommands;
import bridge.domain.constants.MoveCommands;
import bridge.domain.move_result.MoveResults;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * TODO 필드(인스턴스 변수) 추가 가능
 * TODO 메서드 이름 변경 불가!!!!!!!
 * TODO 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능
 * TODO 게임 진행을 위해 필요한 메서드를 추가하거나 변경 가능
 */
public class BridgeGame {

    private static final String GAME_FAIL = "실패";

    private final Bridge bridge;
    private final Player player;
    private final MoveResults moveResults;

    public BridgeGame(final Bridge bridge, final Player player, final MoveResults moveResults) {
        this.bridge = bridge;
        this.player = player;
        this.moveResults = moveResults;
    }

    public boolean positionIsNotMoreThan(final BridgeSize bridgeSize) {
        return player.positionIsNotMoreThan(bridgeSize);
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

    public String retryOrQuit(final GameCommands gameCommand, final String gameResult) {
        if (gameCommand.is(RETRY)) {
            retry();
            return gameResult;
        }

        return GAME_FAIL;
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

}
