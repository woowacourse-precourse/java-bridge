package bridge.gameComponent;

import bridge.exception.ExceptionMessage;
import bridge.util.MoveResult;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int bridgeIndex; //현재까지 움직인 칸
    private int lastStep; //마지막 칸
    private int numberOfTrials;
    private char[][] moveRecord; //현재까지 움직인 다리 기록
    private Bridge bridge;

    public BridgeGame(Bridge bridge) {
        if (bridge == null) {
            throw new IllegalArgumentException(ExceptionMessage.NULL_INPUT.getMessage());
        }
        this.bridge = bridge;
        this.bridgeIndex = -1;
        this.lastStep = bridge.getBridge().size() - 1;
        this.numberOfTrials = 1;
        this.moveRecord = new char[2][this.lastStep + 1];
    }
    public void moveForward(MoveResult moveResult, String move) {
        if(bridgeIndex >= lastStep) {
            throw new IllegalStateException(ExceptionMessage.CANNOT_MOVE_FURTHER.getMessage());
        }
        recordCurrentMove(moveResult, move);
        if(moveResult == MoveResult.CORRECT || moveResult == MoveResult.CORRECT_AND_LAST) {
            bridgeIndex++;
        }
    }
    public void retry() {
        if (isSuccess()) {
            throw new IllegalStateException(ExceptionMessage.GAME_ALREADY_SUCCESS.getMessage());
        }
        this.numberOfTrials++;
        this.bridgeIndex = -1;
        this.moveRecord = new char[2][this.lastStep + 1];
    }

    public boolean isSuccess() {
        if (bridgeIndex == lastStep) return true;
        return false;
    }

    public char[][] getCurrentBridge(MoveResult moveResult) {
        return this.moveRecord;
    }
    private void recordCurrentMove(MoveResult moveResult, String move) {
        int userMoveAsInt = moveToInt(move);
        int userNotMoveAsInt = notMoveToInt(move);
        char markOX = moveResult.getMark();
        this.moveRecord[userMoveAsInt][bridgeIndex + 1] = markOX;
        this.moveRecord[userNotMoveAsInt][bridgeIndex + 1] = ' ';
    }
    public MoveResult isCorrectMove(String move) {
        boolean isPossibleMove = this.bridge.isPossibleMove(this.bridgeIndex + 1, move);
        if(isPossibleMove && this.bridgeIndex + 1 == this.lastStep) return MoveResult.CORRECT_AND_LAST;
        if(isPossibleMove) return MoveResult.CORRECT;
        return MoveResult.WRONG;
    }
    private int moveToInt(String move) {
        if (move.equals("U")) return 0;
        return 1;
    }

    private int notMoveToInt(String move) {
        if (move.equals("U")) return 1;
        return 0;
    }
    public int getNumberOfTrials() {
        return numberOfTrials;
    }

    public int getBridgeIndex() {
        return bridgeIndex;
    }

    public int getLastStep() {
        return lastStep;
    }
    public char[][] getMoveRecord() {
        return moveRecord;
    }
}
