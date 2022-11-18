package bridge.domain;

public interface ProcessHelper {


    boolean checkBridgeSize(String bridgeLength);

    boolean checkCharIsUOrD(String moving);

    boolean checkCharIsROrQ(String gameCommand);
}
