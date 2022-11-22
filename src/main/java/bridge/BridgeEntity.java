package bridge;

import java.util.LinkedList;
import java.util.List;

public class BridgeEntity implements BridgeRepository {

    private List<String> bridgeEntity;
    private final BridgeMaker bridgeMaker;


    public BridgeEntity() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridgeEntity = new LinkedList<>();

    }

    // 다리를 재사용 할 수 있도록 설정한다.
    @Override
    public List<String> manageBridgeStatus() {

        bridgeEntity = bridgeMaker.makeBridge(new FrontController().readBridgeSize());

        return bridgeEntity;

    }


}
