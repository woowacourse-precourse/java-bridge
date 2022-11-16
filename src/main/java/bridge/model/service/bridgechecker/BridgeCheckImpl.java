package bridge.model.service.bridgechecker;

public class BridgeCheckImpl implements BridgeChecker {

    @Override
    public boolean check(String userMoving, String targetBridge) {
        if (userMoving.equals(targetBridge)) {
            return true;
        }
        return false;
    }
}
