package bridge.domain;

import java.util.*;

import static bridge.domain.ConstantMessage.GAME_RESULT_SUCCESS_OR_FAIL_MESSAGE;
import static bridge.domain.ConstantMessage.GAME_RETRY_COUNT_MESSAGE;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int bridgeLength;
    private boolean isPlayerMoveSuccess;
    private boolean isSuccessGame;
    private int bridgeIdx;
    private int tryCount;
    private List<String> bridge;
    private List<String> playerMoveRecord;
    private List<MoveAnswer> playerMoveWhetherAnswer;
    private StringBuilder printPlayerMoveUp;
    private StringBuilder printPlayerMoveDown;
    private List<StringBuilder> printPlayerMove;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveDirection , int bridgeIdx) {
        playerMoveRecord.add(moveDirection);
        if(bridge.get(bridgeIdx).equals(moveDirection)) {
            isPlayerMoveSuccess = true;
            return;
        }
        isPlayerMoveSuccess = false;
    }

    public void makePrintResult(){
        initializeBuilder();
        playerMoveWhetherAnswer();
        appendOpenSquareBrackets();
        for (; bridgeIdx < playerMoveRecord.size() ; bridgeIdx++) {
            makePrintResultIfUp(bridgeIdx);
            makePrintResultIfDown(bridgeIdx);
        }
        appendCloseSquareBrackets();
        return;
    }

    public void makePrintResultIfUp(int bridgeIdx){
        if(bridgeIdx == 0) {
            if(playerMoveWhetherAnswer.get(bridgeIdx).equals(MoveAnswer.UP_TRUE)) {
                printPlayerMoveUp.append(" O ");
                return;
            }
            if(playerMoveWhetherAnswer.get(bridgeIdx).equals(MoveAnswer.UP_FALSE)) {
                printPlayerMoveUp.append(" X ");
                return;
            }
            printPlayerMoveUp.append("   ");
            return;
        }

        if(playerMoveWhetherAnswer.get(bridgeIdx).equals(MoveAnswer.UP_TRUE)) {
            printPlayerMoveUp.append("| O ");
            return;
        }
        if(playerMoveWhetherAnswer.get(bridgeIdx).equals(MoveAnswer.UP_FALSE)) {
            printPlayerMoveUp.append("| X ");
            return;
        }
        printPlayerMoveUp.append("|   ");
    }

    public void makePrintResultIfDown(int bridgeIdx){
        if(bridgeIdx == 0) {
            if(playerMoveWhetherAnswer.get(bridgeIdx).equals(MoveAnswer.DOWN_TRUE)) {
                printPlayerMoveDown.append(" O ");
                return;
            }
            if(playerMoveWhetherAnswer.get(bridgeIdx).equals(MoveAnswer.DOWN_FALSE)) {
                printPlayerMoveDown.append(" X ");
                return;
            }
            printPlayerMoveDown.append("   ");
            return;
        }
        if(playerMoveWhetherAnswer.get(bridgeIdx).equals(MoveAnswer.DOWN_TRUE)) {
            printPlayerMoveDown.append("| O ");
            return;
        }
        if(playerMoveWhetherAnswer.get(bridgeIdx).equals(MoveAnswer.DOWN_FALSE)) {
            printPlayerMoveDown.append("| X ");
            return;
        }
        printPlayerMoveDown.append("|   ");
    }

    public void playerMoveWhetherAnswer(){
        for (int bridgeIdx =0 ; bridgeIdx < playerMoveRecord.size() ; bridgeIdx++) {
            MoveAnswer moveAnswer = comparePlayerMoveAndBridge(bridgeIdx);
            playerMoveWhetherAnswer.add(moveAnswer);
        }
    }

    public MoveAnswer comparePlayerMoveAndBridge(int bridgeIdx){
        if(bridge.get(bridgeIdx).equals(playerMoveRecord.get(bridgeIdx)) && playerMoveRecord.get(bridgeIdx).equals(MoveDirection.U.strMoveDirection))
            return MoveAnswer.UP_TRUE;
        if(bridge.get(bridgeIdx).equals(playerMoveRecord.get(bridgeIdx)) && playerMoveRecord.get(bridgeIdx).equals(MoveDirection.D.strMoveDirection))
            return MoveAnswer.DOWN_TRUE;
        if(!bridge.get(bridgeIdx).equals(playerMoveRecord.get(bridgeIdx)) && playerMoveRecord.get(bridgeIdx).equals(MoveDirection.U.strMoveDirection))
            return MoveAnswer.UP_FALSE;
        return MoveAnswer.DOWN_FALSE;
    }

    public void appendOpenSquareBrackets(){
        printPlayerMoveUp.append("[");
        printPlayerMoveDown.append("[");
    }

    public void appendCloseSquareBrackets(){
        printPlayerMoveUp.append("]");
        printPlayerMoveDown.append("]");
    }
    

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public void gameSuccess(){
        this.isSuccessGame = true;
    }

    public boolean isMoveSuccess(){
        return isPlayerMoveSuccess;
    }

    public void initializeBridgeGame(List<String> bridge){
        this.bridge = bridge;
        this.playerMoveRecord = new ArrayList<>();
        this.printPlayerMove = new ArrayList<>();
        this.playerMoveWhetherAnswer = new ArrayList<>();
        this.printPlayerMoveUp = new StringBuilder();
        this.printPlayerMoveDown = new StringBuilder();
        this.tryCount = 1;
        this.isSuccessGame = false;
        bridgeIdx = 0;
    }

    public void initializePlayerMoveRecord(){
        this.playerMoveRecord = new ArrayList<>();
        this.bridgeIdx =0;
        this.tryCount++;
    }

    public void initializeBuilder(){
        this.printPlayerMove = new ArrayList<>();
        this.printPlayerMoveUp = new StringBuilder();
        this.printPlayerMoveDown = new StringBuilder();
        this.bridgeIdx =0;
        this.playerMoveWhetherAnswer = new ArrayList<>();
    }

    public void setBridgeLength(int bridgeLength) {
        this.bridgeLength = bridgeLength;
    }

    public int getBridgeLength() {
        return bridgeLength;
    }

    public int getBridgeSize(){
        return bridge.size();
    }

    public int getBridgeIdx() {
        return bridgeIdx;
    }

    public BridgeGame(int bridgeLength, int tryCount) {
        this.bridgeLength = bridgeLength;
        this.tryCount = tryCount;
    }


}
