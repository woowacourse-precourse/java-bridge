package bridge;

import java.util.List;

public class BridgeGameService {
    
    public List<String> createBridge(int size) {
        return new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size);
    }
}
