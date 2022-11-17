package bridge.domain;

import static bridge.domain.constants.GameCommands.RETRY_GAME_COMMAND;
import static bridge.domain.constants.MoveResultsSign.MOVE_FAIL;
import static bridge.domain.constants.MoveResultsSign.MOVE_SUCCESS;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * TODO 필드(인스턴스 변수) 추가 가능
 * TODO 메서드 이름 변경 불가!!!!!!!
 * TODO 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능
 * TODO 게임 진행을 위해 필요한 메서드를 추가하거나 변경 가능
 */
public class BridgeGame {

    private final Bridge bridge;
    private final Player player;
    private final MoveResults moveResults;

    public BridgeGame(Bridge bridge, Player player, MoveResults moveResults) {
        this.bridge = bridge;
        this.player = player;
        this.moveResults = moveResults;
    }

    public String matchResult(String moveCommand) {
        if (bridge.isMatched(player, moveCommand)) {
            return MOVE_SUCCESS;
        }

        return MOVE_FAIL;
    }

    public MoveResults moveResults(String moveCommand, String resultSign) {
        moveResults.addResults(moveCommand, resultSign);
        return moveResults;
    }

    public boolean ongoing(int bridgeSize) {
        return player.inTheGame(bridgeSize);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String resultSign) {
        if (resultSign.equals(MOVE_SUCCESS)) {
            player.move();
        }
    }

    public String retryOrQuit(String gameCommand, String result) {
        if (gameCommand.equals(RETRY_GAME_COMMAND)) {
            retry();
            return result;
        }

        return "실패";
    }

    /**
     * TODO 혹시 제출 테스트 케이스 실패하면 여기의 private를 의심하렴..
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private void retry() {
        moveResults.reset();
        player.initPosition();
        player.increaseNumberOfChallenges();
    }

    public MoveResults moveResults() {
        return moveResults;
    }

    public Player player() {
        return player;
    }
}
