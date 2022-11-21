package bridge.service;

import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final OutputView outputView = new OutputView();
    private List<String> bridgeList;

    private final List<String> upBridge;
    private final List<String> downBridge;

    private int moveCount;
    private int gameAttemptCount;
    private boolean progressStatus;

    public BridgeGame(List<String> bridgeList) {
        this.bridgeList = bridgeList;
        this.moveCount = 0;
        this.gameAttemptCount = 1;
        this.progressStatus = true;
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }
    public void gameInProgress(String moving) {
        progressStatus = true;
        createBridgeResult(moving);
        outputView.printBridge(upBridge, downBridge);
        moveCount++;
    }

    public void createBridgeResult(String moving){
        if (moving.equals("U")) {
            createUpBridgeResult(moveCount);
        }
        if (moving.equals("D")) {
            createDownBridgeResult(moveCount);
        }
    }
    public void createUpBridgeResult(int moveCount) {
        downBridge.add(" ");
        if (bridgeList.get(moveCount).equals("U")) {
            appendCorrectAnswer(upBridge);
        }
        if (bridgeList.get(moveCount).equals("D")) {
            appendWrongAnswer(upBridge);
        }
    }
    public void createDownBridgeResult(int moveCount) {
        upBridge.add(" ");
        if (bridgeList.get(moveCount).equals("D")) {
            appendCorrectAnswer(downBridge);
        }
        if (bridgeList.get(moveCount).equals("U")) {
            appendWrongAnswer(downBridge);
        }
    }
    public void appendCorrectAnswer(List<String> bridgeList){
        bridgeList.add("O");
    }
    public void appendWrongAnswer(List<String> bridgeList) {
        bridgeList.add("X");
        progressStatus = false;
    }

    public boolean isOver() {
        if (progressStatus && moveCount < bridgeList.size()) {
            return false;
        }
        return true;
    }

    public boolean isRetry(String gameCommand) {
        if (gameCommand.equals("R")) {
            initBeforeRestart();
        }
        return progressStatus;
    }
    public void initBeforeRestart(){
        progressStatus = true;
        moveCount = 0;
        gameAttemptCount++;
        upBridge.clear();
        downBridge.clear();
    }

    public boolean isSuccess(){
        return progressStatus && moveCount == bridgeList.size();
    }
    public void lastMapResult(){
        outputView.printResultPrefixMessage();
        outputView.printBridge(upBridge, downBridge);
        outputView.printGameSuccessOrNot(gameSuccess());
        outputView.printNumberOfAttempts(gameAttemptCount);
    }
    public String gameSuccess(){
        if(progressStatus) {
            return "성공";
        }
        return "실패";
    }
}
