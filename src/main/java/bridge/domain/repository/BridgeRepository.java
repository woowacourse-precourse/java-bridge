package bridge.domain.repository;

import bridge.presentation.dto.BridgeSize;

public class BridgeRepository {
    private static final BridgeRepository instance=new BridgeRepository();
    private BridgeSize bridgeSize;

    private BridgeRepository(){}

    public static BridgeRepository getInstance(){
        return instance;
    }

    public void saveBridgeSize(BridgeSize bridgeSize){
        this.bridgeSize=bridgeSize;
    }

    public BridgeSize getBridgeSize() {
        return bridgeSize;
    }
}
