package bridge.domain;

import bridge.vallidation.BridgeValidation;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;

import static bridge.constant.BridgeConstant.BRIDGE_RESULT_CORRECT;
import static bridge.constant.BridgeConstant.BRIDGE_RESULT_WRONG;

public class User {
    private List<String> userMovings = new ArrayList<>();
    private Bridge bridge;
    private BridgeResult bridgeResult;
    private boolean moveStatus;
    public User(Bridge bridge, BridgeResult bridgeResult) {
        this.bridge = bridge;
        this.bridgeResult = bridgeResult;
        moveStatus = true;
    }

    public void move(String userMoving) {
        boolean canMove = bridge.checkCanMove(updateUserLocation(userMoving), userMoving);
        updateUserMove(canMove, userMoving);
    }

    private int updateUserLocation(String userMoving) {
        userMovings.add(userMoving);
        int location = userMovings.size()-1;
        BridgeValidation.isValidUserLocation(location, bridge.getSize());
        return location;
    }

    private void updateUserMove(boolean canMove, String userMoving) {
        if (canMove) {
            bridgeResult.saveBridgeResult(BRIDGE_RESULT_CORRECT, userMoving);
        }
        if (!canMove) {
            bridgeResult.saveBridgeResult(BRIDGE_RESULT_WRONG,userMoving);
            this.moveStatus = false;
        }
    }

    public boolean isFinishedMove() {
        if (userMovings.size() == bridge.getSize() && moveStatus) {
            return true;
        }
        return false;
    }

    public boolean getMoveStatus() {
        return this.moveStatus;
    }
}
