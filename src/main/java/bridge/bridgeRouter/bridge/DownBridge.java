package bridge.bridgeRouter.bridge;

public class DownBridge implements Bridge {
    @Override
    public String getDirection() {
        return "D";
    }

    @Override
    public int getValue() {
        return 0;
    }

    @Override
    public int getIndex() {
        return 1;
    }
}
