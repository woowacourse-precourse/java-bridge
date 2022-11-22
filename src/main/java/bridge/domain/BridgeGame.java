package bridge.domain;

import java.util.*;

import static bridge.domain.ConstantMessage.GAME_RESULT_SUCCESS_OR_FAIL_MESSAGE;
import static bridge.domain.ConstantMessage.GAME_RETRY_COUNT_MESSAGE;
import static bridge.domain.SuccessOrFail.성공;
import static bridge.domain.SuccessOrFail.실패;
import static bridge.domain.MoveAnswer.UP_TRUE;
import static bridge.domain.MoveAnswer.UP_FALSE;
import static bridge.domain.MoveAnswer.DOWN_TRUE;
import static bridge.domain.MoveAnswer.DOWN_FALSE;
import static bridge.domain.MoveDirection.U;
import static bridge.domain.MoveDirection.D;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    private SuccessOrFail isPlayerMoveSuccess;
    private SuccessOrFail isSuccessGame;
    private int bridgeIdx;
    private int tryCount;
    private List<String> bridge;
    private List<MoveDirection> playerMoveRecord;
    private List<MoveAnswer> playerMoveWhetherAnswer;
    private StringBuilder printPlayerMoveUp;
    private StringBuilder printPlayerMoveDown;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String moveDirection , int bridgeIdx) {
        playerMoveRecord.add(moveDirectionTypeConversion(moveDirection));
        if(bridge.get(bridgeIdx).equals(moveDirection)) {
            isPlayerMoveSuccess = 성공;
            return;
        }
        isPlayerMoveSuccess = 실패;
    }

    private MoveDirection moveDirectionTypeConversion(String moveDirection) {
        if(U.strMoveDirection.equals(moveDirection))
            return U;
        return D;
    }

    public void makePrintResult(){
        initializeBuilderForMakePrintingResult();
        playerMoveWhetherAnswer();
        appendOpenSquareBrackets();
        for (; bridgeIdx < playerMoveRecord.size() ; bridgeIdx++) {
            makePrintResultIfUp(bridgeIdx);
            makePrintResultIfDown(bridgeIdx);
        }
        appendCloseSquareBrackets();
    }

    private void makePrintResultIfUp(int bridgeIdx){
        if(bridgeIdx == 0) {
            appendPlayerMoveUpResultAtFirstMove(bridgeIdx);
            return;
        }
        appendPlayerMoveUpResultNotFirstMove(bridgeIdx);

    }

    private void makePrintResultIfDown(int bridgeIdx){
        if(bridgeIdx == 0) {
            appendPlayerMoveDownResultAtFirstMove(bridgeIdx);
            return;
        }
        appendPlayerMoveDownResultNotFirstMove(bridgeIdx);
    }

    private void appendPlayerMoveUpResultNotFirstMove(int bridgeIdx) {
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

    private void appendPlayerMoveUpResultAtFirstMove(int bridgeIdx ) {
        if(playerMoveWhetherAnswer.get(bridgeIdx).equals(UP_TRUE)) {
            printPlayerMoveUp.append(" O ");
            return;
        }
        if(playerMoveWhetherAnswer.get(bridgeIdx).equals(UP_FALSE)) {
            printPlayerMoveUp.append(" X ");
            return;
        }
        printPlayerMoveUp.append("   ");
    }

    private void appendPlayerMoveDownResultNotFirstMove(int bridgeIdx ) {
        if(playerMoveWhetherAnswer.get(bridgeIdx).equals(DOWN_TRUE)) {
            printPlayerMoveDown.append("| O ");
            return;
        }
        if(playerMoveWhetherAnswer.get(bridgeIdx).equals(DOWN_FALSE)) {
            printPlayerMoveDown.append("| X ");
            return;
        }
        printPlayerMoveDown.append("|   ");
    }

    private void appendPlayerMoveDownResultAtFirstMove(int bridgeIdx) {
        if(playerMoveWhetherAnswer.get(bridgeIdx).equals(DOWN_TRUE)) {
            printPlayerMoveDown.append(" O ");
            return;
        }
        if(playerMoveWhetherAnswer.get(bridgeIdx).equals(DOWN_FALSE)) {
            printPlayerMoveDown.append(" X ");
            return;
        }
        printPlayerMoveDown.append("   ");
    }



    public void playerMoveWhetherAnswer(){
        for (int bridgeIdx =0 ; bridgeIdx < playerMoveRecord.size() ; bridgeIdx++) {
            MoveAnswer moveAnswer = comparePlayerMoveAndBridge(bridgeIdx);
            playerMoveWhetherAnswer.add(moveAnswer);
        }
    }

    private MoveAnswer comparePlayerMoveAndBridge(int bridgeIdx){
        String playerMoveDirection = playerMoveRecord.get(bridgeIdx).strMoveDirection;

        if(bridge.get(bridgeIdx).equals(playerMoveDirection) && playerMoveRecord.get(bridgeIdx).equals(U))
            return UP_TRUE;
        if(bridge.get(bridgeIdx).equals(playerMoveDirection) && playerMoveRecord.get(bridgeIdx).equals(D))
            return DOWN_TRUE;
        if(!bridge.get(bridgeIdx).equals(playerMoveDirection) && playerMoveRecord.get(bridgeIdx).equals(U))
            return UP_FALSE;
        return DOWN_FALSE;
    }

    private void appendOpenSquareBrackets(){
        printPlayerMoveUp.append("[");
        printPlayerMoveDown.append("[");
    }

    private void appendCloseSquareBrackets(){
        printPlayerMoveUp.append("]");
        printPlayerMoveDown.append("]");
    }

    public void printResult() {
        System.out.println(printPlayerMoveUp);
        System.out.println(printPlayerMoveDown);
    }

    public void printFinalResult(){
        System.out.println(GAME_RESULT_SUCCESS_OR_FAIL_MESSAGE + isSuccessGame);
        System.out.println(GAME_RETRY_COUNT_MESSAGE + tryCount);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String gameRetryCommand) {
        if(gameRetryCommand.equals(GameRetryCommand.R.command)){
            initializePlayerMoveRecord();
            return true;
        }
        return false;
    }

    public void gameSuccess(){
        this.isSuccessGame = 성공;
    }

    public boolean isFinish(){
        if(bridgeIdx < bridge.size())
            return false;
        return true;
    }

    public SuccessOrFail isMoveSuccess(){
        return isPlayerMoveSuccess;
    }

    public void initializeBridgeGameAtGameStart(List<String> bridge){
        this.bridge = bridge;
        this.playerMoveRecord = new ArrayList<>();
        this.playerMoveWhetherAnswer = new ArrayList<>();
        this.printPlayerMoveUp = new StringBuilder();
        this.printPlayerMoveDown = new StringBuilder();
        this.tryCount = 1;
        this.isSuccessGame = 실패;
        bridgeIdx = 0;
    }

    public void initializePlayerMoveRecord(){
        this.playerMoveRecord = new ArrayList<>();
        this.bridgeIdx =0;
        this.tryCount++;
    }

    public void initializeBuilderForMakePrintingResult(){
        this.printPlayerMoveUp = new StringBuilder();
        this.printPlayerMoveDown = new StringBuilder();
        this.bridgeIdx =0;
        this.playerMoveWhetherAnswer = new ArrayList<>();
    }

    public int getBridgeIdx() {
        return bridgeIdx;
    }

    public BridgeGame( int tryCount) {
        this.tryCount = tryCount;
    }


}
