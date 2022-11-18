package bridge.persistence;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRepository;
import java.util.ArrayList;
import java.util.List;

// 다리의 상태를 관리한다.
public class BridgeRepositoryImpl implements BridgeRepository {

    private List<String> bridgeEntity;
    private BridgeMaker bridgeMaker;
    int size;

    public BridgeRepositoryImpl() {
        this.bridgeEntity = new ArrayList<>();

    }

    public List<String> manageBridgeStatus() {

        bridgeEntity = bridgeMaker.makeBridge(size);
        return bridgeEntity;

    }
}
