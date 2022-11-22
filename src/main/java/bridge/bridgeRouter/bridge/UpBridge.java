package bridge.bridgeRouter.bridge;

public class UpBridge implements Bridge {
    @Override
    public String getDirection() {
        return "U";
    }

    @Override
    public int getValue() {
        return 1;
    }

    @Override
    public int getIndex() {
        return 0;
    }
}
