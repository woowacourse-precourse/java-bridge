package bridge.util;

/**
 * 다리 건너기 게임의 기준에 알맞은지 판단하는 클래스
 */
public class BridgeGameStandard {
        private static final int MINIMUM_BRIDGE_SIZE = 3;
        private static final int MAXIMUM_BRIDGE_SIZE = 20;
                                                  
    /**
     * 다리 길이가 유효한지 판단할 때 사용하는 메서드
     */
    public boolean isValidBridgeSize(int bridgeSize) {
        if (bridgeSize < MINIMUM_BRIDGE_SIZE) {
            return false;
        }
        
        if (MAXIMUM_BRIDGE_SIZE < bridgeSize) {
            return false;
        }

        return true;
    }
}