package domain;

import view.InputMessage;
import view.InputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    InputView inputView = new InputView();

    private int userPos;
    private int attempts;
    private boolean success;

    public BridgeGame() {
        userPos = 0;
        attempts = 1;
        success = false;
    }

    public int getUserPos() {
        return userPos;
    }
    public int getAttempts() { return attempts; }
    public boolean getSuccess() { return success; }

    public boolean move(String choice,AllBridge allBridge) {
        if(choice.equals(allBridge.getBridge().get(userPos))) {
            userPos += 1;
            return false;
        }
        if(retryOrEnd()) {
            return true;
        }
        return false;
    }

    public boolean checkRetry() {
        if(userPos == 0) {
            System.out.println(InputMessage.RESTART.getInputMsg());
            if(inputView.readGameCommand().equals("R")) {
                attempts++;
                return false;
            }
            return false;
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

    public void retry() {
        userPos = 0;
        attempts += 1;
    }
}