package bridge.gameComponent;

import bridge.exception.ExceptionMessage;
import bridge.util.MoveResult;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int currentStep; //현재까지 움직인 칸
    private int lastStep; //마지막 칸
    private int numberOfTrials;
    private char[][] moveRecord; //현재까지 움직인 다리 기록
    private Bridge bridge;

    public BridgeGame(Bridge bridge) {
        if (bridge == null) {
            throw new IllegalArgumentException(ExceptionMessage.NULL_INPUT.getMessage());
        }
        this.bridge = bridge;
        this.currentStep = -1;
        this.lastStep = bridge.getBridge().size() - 1;
        this.numberOfTrials = 1;
        this.moveRecord = new char[2][this.lastStep + 1];
    }

    public int getNumberOfTrials() {
        return numberOfTrials;
    }

    public int getCurrentStep() {
        return currentStep;
    }

    public int getLastStep() {
        return lastStep;
    }
    public char[][] getMoveRecord() {
        return moveRecord;
    }
/**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    /**
     * 마지막 칸까지 도달했다면 1 리턴, 그렇지 않으면 0 리턴
     **/
    public void move() {
        if(currentStep >= lastStep) {
            throw new IllegalStateException(ExceptionMessage.CANNOT_MOVE_FURTHER.getMessage());
        }
        currentStep++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        if (isSuccess()) throw new IllegalStateException(ExceptionMessage.GAME_ALREADY_SUCCESS.getMessage());
        this.numberOfTrials++;
        this.currentStep = -1;
        this.moveRecord = new char[2][this.lastStep + 1];
    }

    public boolean isSuccess() {
        if (currentStep == lastStep) return true;
        return false;
    }

    public char[][] getBridgeToCurrentPosition(MoveResult moveResult) {
        String userMove = inferUserMove(moveResult);
        int userMoveAsInt = moveToInt(userMove);
        int userNotMoveAsInt = notMoveToInt(userMove);
        if (moveResult == MoveResult.CORRECT || moveResult == MoveResult.CORRECT_AND_LAST) {
            this.moveRecord[userMoveAsInt][currentStep] = 'O';
            this.moveRecord[userNotMoveAsInt][currentStep] = ' ';
            return this.moveRecord;
        }
        this.moveRecord[userMoveAsInt][currentStep + 1] = 'X';
        this.moveRecord[userNotMoveAsInt][currentStep + 1] = ' ';
        return this.moveRecord;
    }

    public MoveResult isCorrectMove(String move) {
        boolean isPossibleMove = this.bridge.isPossibleMove(this.currentStep + 1, move);
        if(isPossibleMove && this.currentStep + 1 == this.lastStep) return MoveResult.CORRECT_AND_LAST;
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
        /* U true => [0][index] = 'O'
         * U false => [1][index + 1] = 'X'
         * D true => [1][index] = 'O'
         * D false => [0][index + 1] = 'X'
         */
    private String inferUserMove(MoveResult moveResult) {
        if(moveResult == MoveResult.CORRECT || moveResult == MoveResult.CORRECT_AND_LAST) {
            return this.bridge.getBridge().get(this.currentStep);
        }
        String supposedToBeRightAnswer = this.bridge.getBridge().get(this.currentStep + 1);
        if(supposedToBeRightAnswer.equals("U")) return "D";
        return "U";
    }
}
