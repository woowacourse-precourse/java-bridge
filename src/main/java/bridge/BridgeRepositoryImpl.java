package bridge;


import java.util.LinkedList;
import java.util.List;

public class BridgeRepositoryImpl implements BridgeRepository {

    private List<String> bridgeEntity;
    BridgeMaker bridgeMaker;

    public BridgeRepositoryImpl() {
        bridgeEntity = new LinkedList<>();
    }

    @Override
    public List<String> manageStatus(int size) {
        bridgeEntity = bridgeMaker.makeBridge(size);
        return bridgeEntity;

    }
}
