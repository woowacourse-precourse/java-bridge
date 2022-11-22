package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import static bridge.constant.BridgeConstant.BRIDGE_RESULT_CORRECT;
import static bridge.constant.BridgeConstant.BRIDGE_RESULT_WRONG;

public class User {
    private List<String> userMovings = new ArrayList<>();
    private Bridge bridge;
    private BridgeResult bridgeResult;

    public User(Bridge bridge, BridgeResult bridgeResult) {
        this.bridge = bridge;
        this.bridgeResult = bridgeResult;

    }

    public void init() {
        userMovings.clear();
    }

    public void move(String userMoving) {
        boolean canMove = bridge.checkCanMove(updateUserMove(userMoving), userMoving);

        if (canMove) {
            bridgeResult.saveBridgeResult(BRIDGE_RESULT_CORRECT, userMoving);
        }
        if (!canMove) {
            bridgeResult.saveBridgeResult(BRIDGE_RESULT_WRONG,userMoving);
        }
    }

    private int updateUserMove(String userMoving) {
        userMovings.add(userMoving);
        return userMovings.size() - 1;
    }
}
