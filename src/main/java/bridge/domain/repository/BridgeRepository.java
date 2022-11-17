package bridge.domain.repository;

import bridge.presentation.dto.BridgeSize;
import bridge.presentation.dto.SelectMove;

import java.util.List;

public class BridgeRepository {
    private static final BridgeRepository instance=new BridgeRepository();
    private List<String> bridge;
    private BridgeSize bridgeSize;
    private SelectMove selectMove;

    private BridgeRepository(){}

    public static BridgeRepository getInstance(){
        return instance;
    }

    public void saveBridgeSize(BridgeSize bridgeSize){
        this.bridgeSize=bridgeSize;
    }
    public void saveSelectMove(SelectMove selectMove){this.selectMove=selectMove;}
    public void updateBridge(List<String> bridge){this.bridge=bridge;}

    public BridgeSize getBridgeSize() {
        return bridgeSize;
    }
    public SelectMove getSelectMove() {
        return selectMove;
    }
    public List<String> getBridge() {
        return bridge;
    }
}
