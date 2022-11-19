package bridge.bridgeMaker.bridge;

public class DownBridge implements Bridge {
    @Override
    public String getDirection() {
        return "D";
    }

    @Override
    public int getValue() {
        return 0;
    }
}
