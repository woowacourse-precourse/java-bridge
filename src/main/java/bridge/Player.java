package bridge;

import java.util.List;

public class Player {
    private final int bridgeSize;
    private final List<String> bridge;

//    public Player(PlayerBridgeSizeDto playerBridgeSizeDto, BridgeDto bridgeDto) {
//        this.bridgeSize = playerBridgeSizeDto.getBridgeSize();
//        this.bridge = bridgeDto.getBridge();
//    }


    public Player(int bridgeSize, List<String> bridge) {
        this.bridgeSize = bridgeSize;
        this.bridge = bridge;
    }

    public int getBridgeSize() {
        return bridgeSize;
    }

    public String getBridgeCorrectLocation(int location) {
        return bridge.get(location);
    }

    public List<String> getBridge() {
        return bridge;
    }
}
