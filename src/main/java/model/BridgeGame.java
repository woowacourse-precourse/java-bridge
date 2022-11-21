package model;

import controller.InputController;
import view.InputMessage;
import view.OutputMessage;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputController inputController = new InputController();
    private int userPos;
    private int attempts;
    private boolean success;

    public BridgeGame() {
        userPos = 0;
        attempts = 1;
        success = false;
    }

    public int getAttempts() { return attempts; }
    public boolean getSuccess() { return success; }

    public void move(String choice,AllBridge allBridge) {
        if(choice.equals(allBridge.getBridge().get(userPos))) {
            BridgeState.addString(allBridge.getBridge().get(userPos));
            userPos += 1;
            return;
        }
        BridgeState.addXString(allBridge.getBridge().get(userPos));
        userPos = 0;
    }

    public boolean retry(AllBridge allBridge) {
        if(checkFinish(allBridge) || checkRetry()) { return true; }
        if(userPos == 0) { initBridge(); }
        return false;
    }

    public boolean checkRetry() {
        if(userPos == 0) {
            System.out.println(InputMessage.RESTART.getInputMsg());
            if(inputController.getCommand().equals("R")) {
                attempts++;
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean checkFinish(AllBridge allBridge) {
        if(userPos == allBridge.getBridge().size()) {
            success = true;
            return true;
        }
        return false;
    }

    public void initBridge() {
        BridgeState.lower = OutputMessage.START.getOutputMsg();
        BridgeState.upper = OutputMessage.START.getOutputMsg();
    }

}