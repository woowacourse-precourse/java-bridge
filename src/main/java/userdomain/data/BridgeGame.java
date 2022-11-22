package userdomain.data;

import userdomain.operator.UserException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BridgeGame {

    UserException exception = new UserException();
    private String bridgeSize;
    private List<String> userMove = new ArrayList<>();
    private String retry;

    public boolean setBridgeSize(String bridgeSize) {
        this.bridgeSize = bridgeSize;
        return exception.checkBridgeSize(bridgeSize);
    }

    public int getBridgeSize() {
        return Integer.valueOf(bridgeSize);
    }
    public List<String> getMoveList() {
        return Collections.unmodifiableList(userMove);
    }

    public String getRetry() {
        return retry;
    }

    public boolean move(String userMove) {
        boolean inputMove = exception.checkUserMove(userMove);
        if (inputMove == false) {
            this.userMove.add(userMove);
            return inputMove;
        }
        return inputMove;
    }

    public boolean retry(String retry) {
        this.retry = retry;
        return exception.checkRetry(retry);
    }

    public void initializeUserMove() {
        userMove.clear();
    }


}
