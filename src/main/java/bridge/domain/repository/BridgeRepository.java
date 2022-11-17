package bridge.domain.repository;

import bridge.presentation.dto.BridgeSize;
import bridge.presentation.dto.SelectMove;

public class BridgeRepository {
    private static final BridgeRepository instance=new BridgeRepository();
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

    public BridgeSize getBridgeSize() {
        return bridgeSize;
    }
    public SelectMove getSelectMove() {
        return selectMove;
    }
}
