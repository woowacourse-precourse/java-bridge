package bridge;

public class ErrorThrow {

    public static void bridgeSizeNotNumber() {
        throw new IllegalArgumentException(ErrorResource.ERROR_START+ErrorResource.BRIDGE_SIZE_FRONT+
                ErrorResource.NOT_NUMBER);
    }
    public static void bridgeSizeNotInRange(int minBridgeSize,int maxBridgeSize) {
        throw new IllegalArgumentException(ErrorResource.ERROR_START + ErrorResource.NOT_NUMBER);
    }
    public void moveShouldBe(){

    }
}

